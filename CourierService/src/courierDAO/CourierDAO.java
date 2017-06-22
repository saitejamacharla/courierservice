package courierDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

import courierconnection.ConnectionUtil;
import courierentity.Courier;

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
		tx.begin();
		getEntityManager().merge(courier);
		tx.commit();

	}

	public void deleteCourier(Courier selectedCourier) {
		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		tx.begin();
		getEntityManager().remove(
				getEntityManager().contains(selectedCourier) ? selectedCourier
						: getEntityManager().merge(selectedCourier));
		tx.commit();

	}

}
