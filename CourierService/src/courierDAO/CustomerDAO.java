package courierDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

import courierconnection.ConnectionUtil;
import courierentity.Customer;

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
		tx.begin();
		getEntityManager().merge(customer);
		tx.commit();	
		
	}

	public void deletCustomer(Customer selectedCustomer) {
		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		tx.begin();
		getEntityManager().remove(getEntityManager().contains(selectedCustomer) ? selectedCustomer : getEntityManager().merge(selectedCustomer));
		tx.commit();
		
	}

}
