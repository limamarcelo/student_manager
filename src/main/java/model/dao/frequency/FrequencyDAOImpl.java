package model.dao.frequency;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import java.util.List;
import model.entity.frequency.Frequency;
import model.factory.connection.ConnectionFactory;

public class FrequencyDAOImpl implements FrequencyDAO {

	private ConnectionFactory factory;

	public FrequencyDAOImpl() {
		factory = new ConnectionFactory();
	
	public void insertFrequency(Frequency frequency) {
		
		Session session = null;

		try {

			session = factory().openSession();
			session.beginTransaction();

			session.save(frequency);
			
			session.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}

	}

	public void removeFrequency(Frequency frequency) {
		
		Session session = null;

		try {

			session = factory().openSession();
			session.beginTransaction();

			session.remove(frequency);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}

	}

	public void updateFrequency(Frequency frequency) {
		
		Session session = null;

		try {

			session = factory().openSession();
			session.beginTransaction();

			session.update(frequency);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}
}
	public List<Frequency> listFrequency() {

		Session session = null;
		List<Frequency> user = null;

		try {

			session = factory().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();

			CriteriaQuery<Frequency> criteria = construtor.createQuery(Frequency.class);
			Root<Frequency> raizCliente = criteria.from(Frequency.class);

			criteria.select(raizCliente);

			user = session.createQuery(criteria).getResultList();

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

		} finally {

			if (session != null) {
				session.close();
			}
		}

		return user;

	}
}