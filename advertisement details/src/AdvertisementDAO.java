import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AdvertisementDAO {
	public void insert(Advertisement advertisement) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tr = null;
		try {
			tr = s.beginTransaction();
			s.save(advertisement);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			s.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Advertisement> list() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tr = null;
		List<Advertisement> list = new ArrayList<Advertisement>();
		try {
			tr = s.beginTransaction();
			list = s.createCriteria(Advertisement.class).list();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			s.close();
		}
		return list;
	}

	public Advertisement find(int id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tr = null;
		Advertisement advertisement = null;
		try {
			tr = s.beginTransaction();
			advertisement = (Advertisement) s.get(Advertisement.class, id);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			s.close();
		}
		return advertisement;
	}

	public void update(Advertisement advertisement) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(advertisement);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		} finally {
			session.close();

		}
	}
}
