package courierDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import courierconnection.ConnectionUtil;
import courierentity.Customer;
import courierentity.DeliveryTicketDetails;

public class CustomerDAO {

	@PersistenceContext(unitName = "agenda")
	private final EntityManager entityManager;

	public CustomerDAO() {
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

	public void saveCustomer(Customer customer) {
		EntityTransaction tx = getEntityManager().getTransaction();

		try {
			if (!tx.isActive())
				tx.begin();
			getEntityManager().persist(customer);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		}
	}

	public List<Customer> getAllCustomers() {
		Session session = (Session) getEntityManager().getDelegate();
		Query query = session.createQuery("from Customer c");
		List<Customer> customers = query.list();
		return customers;
	}

	public void updateCustomer(Customer customer) {
		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		if (!tx.isActive())
			tx.begin();
		getEntityManager().merge(customer);
		tx.commit();

	}

	public void deletCustomer(Customer selectedCustomer) {
		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		if (!tx.isActive())
			tx.begin();
		getEntityManager()
				.remove(getEntityManager().contains(selectedCustomer) ? selectedCustomer
						: getEntityManager().merge(selectedCustomer));
		tx.commit();

	}

	public List<DeliveryTicketDetails> getCustomerBill(String custName,
			String startDate, String endDate) {
		String query = "select c.packageId, c.assignedCourierNo, c.createdCutomerNo, c.createdDate,"
				+ "c.deliveryCustName, c.deliveryCustPhone,c.deliveryPath,c.deliveryStatus, c.pickUpTime, c.billToDelivery,"
				+ "c.billToPickUp, c.estimatedBlocks,c.estimatedDeliveryDate,c.actualDeliveredDate,c.quotedPrice,c.instructions, cust.name,cour.courierName"
				+ " from CreateDeliveryTicket c LEFT JOIN  courier.customer cust ON cust.customerno = c.createdCutomerNo LEFT JOIN"
				+ " courier cour ON c.assignedCourierNo=cour.courierNO where c.deliveryStatus not in ('Cancelled') and";

		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		if (!tx.isActive())
			tx.begin();
		List<DeliveryTicketDetails> deliveryTicketDetails = null;
		try {
			query = query + " cust.name like '%" + custName + "%'";
			query = query + " and c.createdDate >= '" + startDate
					+ "' and c.createdDate <= '" + endDate + "'";
			SQLQuery sqlQuery = session.createSQLQuery(query);

			List<Object[]> rows = sqlQuery.list();
			deliveryTicketDetails = new ArrayList<DeliveryTicketDetails>();
			for (Object[] row : rows) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				DeliveryTicketDetails details = new DeliveryTicketDetails();
				details.setPackageId(row[0].toString());
				details.setAssignedCourierNo(Integer.parseInt(row[1].toString()));
				details.setCreatedCutomerNo(row[2].toString());
				details.setDeliveryCustName(row[4].toString());
				details.setDeliveryCustPhone(row[5].toString());
				details.setDeliveryPath(row[6].toString());
				try {
					details.setCreatedDate(sdf.parse(row[3].toString()));
					details.setDeliveryStatus(row[7].toString());
					details.setPickUpTime(sdf.parse(row[8].toString()));
					details.setBillToDelivery(Double.parseDouble(row[9]
							.toString()));
					details.setBillToPickUP(Double.parseDouble(row[10]
							.toString()));
					details.setEstimatedBlocks(Integer.parseInt(row[11]
							.toString()));
					details.setEstimatedDeliveryDate(sdf.parse(row[12]
							.toString()));
					details.setActualDeliveryDate(row[13] != null ? sdf
							.parse(row[13].toString()) : null);

				} catch (Exception e) {
					e.printStackTrace();
				}
				details.setQuotedPrice(Double.parseDouble(row[14].toString()));
				details.setInstructions(row[15] != null ? row[15].toString()
						: null);
				details.setCreatedCustomerName(row[16].toString());
				details.setAssignedCourierName(row[17].toString());
				deliveryTicketDetails.add(details);
			}
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			// close();
		}
		return deliveryTicketDetails;
	}
}
