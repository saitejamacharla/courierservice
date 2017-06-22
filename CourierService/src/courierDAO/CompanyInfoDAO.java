package courierDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

import courierconnection.ConnectionUtil;
import courierentity.CompanyInfo;

public class CompanyInfoDAO {
	
	@PersistenceContext(unitName = "agenda")
	private final EntityManager entityManager;

	public CompanyInfoDAO() {
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
	
	public void updateCompanyInfo(CompanyInfo companyInfo) {
		Session session = (Session) getEntityManager().getDelegate();
		CompanyInfo companyInfo2 = (CompanyInfo) session.get(CompanyInfo.class,
				1);
		EntityTransaction tx = getEntityManager().getTransaction();
		try {
		tx.begin();
		companyInfo.setCompanyId(1);
		getEntityManager().merge(companyInfo);
		tx.commit();
		}catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }

	}

	public CompanyInfo getCompanyInfo() {
		Session session = (Session) getEntityManager().getDelegate();
		Query query = session.createQuery("from CompanyInfo e");
		List<CompanyInfo> companyInfos = query.list();
		return companyInfos.get(0);
	}

}
