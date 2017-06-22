package courierDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

import courierconnection.ConnectionUtil;
import courierentity.Users;

public class UserDAO {

	@PersistenceContext(unitName = "agenda")
	private final EntityManager entityManager;

	public UserDAO() {
		this.entityManager = ConnectionUtil.getEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private void close() {
		if (getEntityManager().isOpen()) {
			getEntityManager().close();
		}
		//shutdown();
	}

	private void shutdown() {
		EntityManager em = ConnectionUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.createNativeQuery("SHUTDOWN").executeUpdate();
		em.close();
	}

	public void insertOrderTaker(Users users) {
		EntityTransaction tx = getEntityManager().getTransaction();

		try {
			tx.begin();
			getEntityManager().persist(users);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		} finally {
			close();
		}
	}

	public List<Users> getAllOrderTakers() {
		Session session = (Session) getEntityManager().getDelegate();
		Query query = session
				.createQuery("from Users u where u.role='ordertaker'");
		List<Users> users = query.list();
		return users;
	}

	public void updateOrderTaker(Users users) {
		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			getEntityManager().merge(users);
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		} finally {
			close();
		}
	}

	public void deleteOrderTaker(String selectedValue) {
		Session session = (Session) getEntityManager().getDelegate();
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
			tx.begin();
			Users users = new Users();
			users.setUsername(selectedValue);
			getEntityManager().remove(
					getEntityManager().contains(users) ? users
							: getEntityManager().merge(users));
			tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		} finally {
			close();
		}

	}

	public void updatePassword(Users users, String newPassword) {
		Session session = (Session) getEntityManager().getDelegate();
		Users user = getEntityManager().find(Users.class, users.getUsername());
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
		tx.begin();
		user.setPassword(newPassword);
		tx.commit();
		} catch (Throwable t) {
			t.printStackTrace();
			tx.rollback();
		} finally {
            close();
        }
	}

}
