package courierDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import courierconnection.ConnectionUtil;
import courierentity.Courier;
import courierentity.CreateDeliveryTicket;
import courierentity.DeliveryTicketDetails;

public class DeliveryTicketDAO {

	@PersistenceContext(unitName = "agenda")
	private final EntityManager entityManager;

	public DeliveryTicketDAO() {
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

	public void saveDeliveryDetails(CreateDeliveryTicket deliveryTicket) {
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			if (!tx.isActive())
				tx.begin();
			getEntityManager().persist(deliveryTicket);
			tx.commit();
		} catch (Exception t) {
			t.printStackTrace();
			tx.rollback();
		} finally {
			// close();
		}

	}

	public List<DeliveryTicketDetails> getDeliveryTickets(String date) {
		String query = "select c.packageId, c.assignedCourierNo, c.createdCutomerNo, c.createdDate,"
				+ "c.deliveryCustName, c.deliveryCustPhone,c.deliveryPath,c.deliveryStatus, c.pickUpTime, c.billToDelivery,"
				+ "c.billToPickUp, c.estimatedBlocks,c.estimatedDeliveryDate,c.actualDeliveredDate,c.quotedPrice,c.instructions, cust.name,cour.courierName"
				+ " from CreateDeliveryTicket c LEFT JOIN  courier.customer cust ON cust.customerno = c.createdCutomerNo LEFT JOIN"
				+ " courier cour ON c.assignedCourierNo=cour.courierNO where c.deliveryStatus NOT IN ('Cancelled', 'Delivered')";

		String dateQuery = date != null ? " and c.pickUpTime ='" + date + "'"
				: "";

		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		if (!tx.isActive())
			tx.begin();
		List<DeliveryTicketDetails> deliveryTicketDetails = null;
		try {
			SQLQuery sqlQuery = session.createSQLQuery(query + dateQuery);

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

	public void cancelDeliveryTicket(String packageId) {
		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			if (!tx.isActive())
				tx.begin();
			Query q = session
					.createQuery("update CreateDeliveryTicket set deliveryStatus=:deliveryStatus where packageId=:Id");
			q.setString("deliveryStatus", "Cancelled");
			q.setString("Id", packageId);
			q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			// close();
		}
	}

	public void updateDeliveredStatus(
			DeliveryTicketDetails deliveryTicketDetails) {
		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			if (!tx.isActive())
				tx.begin();
			Query q = session
					.createQuery("update CreateDeliveryTicket set deliveryStatus=:deliveryStatus, actualDeliveredDate=:deliveryDate where packageId=:Id");
			q.setDate("deliveryDate",
					deliveryTicketDetails.getActualDeliveryDate());
			q.setString("deliveryStatus", "Delivered");
			q.setString("Id", deliveryTicketDetails.getPackageId());
			q.executeUpdate();
			long daysDiff = getTimeDiff(
					deliveryTicketDetails.getEstimatedDeliveryDate(),
					deliveryTicketDetails.getActualDeliveryDate());
			double bonus = daysDiff * 1;

			Courier courier = (Courier) session.get(Courier.class,
					deliveryTicketDetails.getAssignedCourierNo());
			Query query = session
					.createQuery("update Courier set courierBonus=:bonus where courierNo=:Id");
			query.setDouble("bonus", courier.getCourierBonus() + bonus);
			query.setInteger("Id", deliveryTicketDetails.getAssignedCourierNo());
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			// close();
		}
	}

	public long getTimeDiff(Date dateOne, Date dateTwo) {
		long diff;
		long timeDiff = Math.abs(dateOne.getTime() - dateTwo.getTime());
		diff = TimeUnit.MILLISECONDS.toDays(timeDiff);
		return diff;
	}

	public List<DeliveryTicketDetails> getDeliveredTickets(String date) {
		String query = "select c.packageId, c.assignedCourierNo, c.createdCutomerNo, c.createdDate,"
				+ "c.deliveryCustName, c.deliveryCustPhone,c.deliveryPath,c.deliveryStatus, c.pickUpTime, c.billToDelivery,"
				+ "c.billToPickUp, c.estimatedBlocks,c.estimatedDeliveryDate,c.actualDeliveredDate,c.quotedPrice,c.instructions, cust.name,cour.courierName"
				+ " from CreateDeliveryTicket c LEFT JOIN  courier.customer cust ON cust.customerno = c.createdCutomerNo LEFT JOIN"
				+ " courier cour ON c.assignedCourierNo=cour.courierNO where c.deliveryStatus IN ('Delivered')";

		String dateQuery = date != null ? " and c.actualDeliveredDate ='"
				+ date + "'" : "";

		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		if (!tx.isActive())
			tx.begin();
		List<DeliveryTicketDetails> deliveryTicketDetails = null;
		try {
			SQLQuery sqlQuery = session.createSQLQuery(query + dateQuery);

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
