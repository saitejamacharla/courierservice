package courierDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

import courierconnection.ConnectionUtil;
import courierentity.Users;

public class LoginDAO {

	@PersistenceContext(unitName = "agenda")
	private final EntityManager entityManager;

	public LoginDAO() {
		this.entityManager = ConnectionUtil.getEntityManager();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Users isAuthenticate(String username, String password) {
		Session session = (Session) getEntityManager().getDelegate();
		Query query = session
				.createQuery("from Users u where u.username = :username and u.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		List list = query.list();
		return (list != null && list.size() > 0) ? (Users) list.get(0) : null;
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

}
