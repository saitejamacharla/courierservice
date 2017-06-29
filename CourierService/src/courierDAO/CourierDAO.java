package courierDAO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import courierMap.WeighedDigraph;
import courierconnection.ConnectionUtil;
import courierentity.CompanyPerfDetails;
import courierentity.Courier;
import courierentity.CourierPerfDetails;
import courierentity.CreateDeliveryTicket;

public class CourierDAO {

	@PersistenceContext(unitName = "agenda")
	private final EntityManager entityManager;

	public CourierDAO() {
		this.entityManager = ConnectionUtil.getEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private void close() {
		if (getEntityManager().isOpen()) {
			getEntityManager().close();
		}
		shutdown();
	}

	private void shutdown() {
		EntityManager em = ConnectionUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createNativeQuery("SHUTDOWN").executeUpdate();
		em.close();
	}

	public void saveCourier(Courier courier) {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			if (!tx.isActive())
				tx.begin();
			getEntityManager().persist(courier);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		}

	}

	public List<Courier> getAllCouriers() {
		Session session = (Session) getEntityManager().getDelegate();
		Query query = session.createQuery("from Courier c");
		List<Courier> couriers = query.list();
		return couriers;
	}

	public void updateCourier(Courier courier) {
		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		if (!tx.isActive())
			tx.begin();
		getEntityManager().merge(courier);
		tx.commit();

	}

	public void deleteCourier(Courier selectedCourier) {
		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		if (!tx.isActive())
			tx.begin();
		getEntityManager().remove(
				getEntityManager().contains(selectedCourier) ? selectedCourier
						: getEntityManager().merge(selectedCourier));
		tx.commit();
	}

	public String getPackageId() {
		Random ran = new Random();
		int number = 100000 + ran.nextInt(900000);
		return "Pack" + String.valueOf(number);
	}

	public double getBill(CreateDeliveryTicket deliveryTicket,
			WeighedDigraph graph, ArrayList<Integer> paths) {
		return graph.findWeight(deliveryTicket.getFromAddress(),
				deliveryTicket.getToAddress(), paths);
	}

	public CourierPerfDetails getCourierPerformance(String name,
			String startDate, String endDate) {
		String query = "select cour.courierNo, cour.courierName, count(c.packageId) as count, cour.courierBonus"
				+ " from CreateDeliveryTicket c left join courier cour on"
				+ " cour.courierNo = c.assignedCourierNo where cour.courierName";

		query = query + " like '%" + name + "%' and c.actualDeliveredDate >='"
				+ startDate + "' and c.actualDeliveredDate <='" + endDate
				+ "' group BY cour.courierNo";

		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		if (!tx.isActive())
			tx.begin();
		CourierPerfDetails courierPerfDetails = null;
		try {
			SQLQuery sqlQuery = session.createSQLQuery(query);

			List<Object[]> rows = sqlQuery.list();
			for (Object[] row : rows) {
				courierPerfDetails = new CourierPerfDetails();
				courierPerfDetails.setCourrierNo(row[0].toString());
				courierPerfDetails.setCourierName(row[1].toString());
				courierPerfDetails.setNoOfDeliveries(row[2].toString());
				courierPerfDetails.setBonus(row[3].toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return courierPerfDetails;

	}

	public CompanyPerfDetails getCompanyPerformance(String month, String year) {
		String query = "select distinct (select count(c.createdCutomerNo) from CreateDeliveryTicket c where MONTH(c.createdDate)='subMonth' and" 
+" YEAR(c.createdDate)='subYear' and c.deliveryStatus='Delivered')" 
+" as customerCount ," 
+" (select count(c.packageId) from CreateDeliveryTicket c where MONTH(c.createdDate)='subMonth' and YEAR(c.createdDate)='subYear' and c.deliveryStatus='Delivered')" 
+" as deliveryCount, sum(quotedPrice) as sales"
+" from CreateDeliveryTicket where MONTH(createdDate)='subMonth' and YEAR(createdDate)='subYear' and deliveryStatus='Delivered'";
		query = query.replaceAll("subMonth", month);
		query = query.replaceAll("subYear", year);
		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		CompanyPerfDetails companyPerfDetails = new CompanyPerfDetails();
		if (!tx.isActive())
			tx.begin();
		try {
			SQLQuery sqlQuery = session.createSQLQuery(query);
			List<Object[]> rows = sqlQuery.list();
			for (Object[] row : rows) {
				companyPerfDetails.setCustomerCount(row[0].toString());
				companyPerfDetails.setDeliveriesCount(row[1] != null ? row[1].toString() : null);
				companyPerfDetails.setSales(row[2]!= null ? row[2].toString() : null);
				double performance = 0.0;
				if(companyPerfDetails.getDeliveriesCount() != null) {
				performance = (Double.parseDouble(companyPerfDetails.getDeliveriesCount())/50)*100;
				String performance1 = new DecimalFormat("#.##").format(performance);
				performance = Double.parseDouble(performance1);
				}
				companyPerfDetails.setMonthPerformance(String.valueOf(performance));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return companyPerfDetails;
	}

	public double getBillToPickUp(WeighedDigraph graph,
			ArrayList<Integer> pickUpPaths, int officePoint, int pickUpAddress) {
		return graph.findWeight(officePoint,
				pickUpAddress, pickUpPaths);
	}
}
