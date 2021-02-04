package model.dao.user;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import java.util.List;
import model.entity.user.User;
import model.factory.connection.ConnectionFactory;

public class UserDAOImpl implements UserDAO {
	
	private ConnectionFactory factory;

	public UserDAOImpl() {
		factory = new ConnectionFactory();
	}
	
	public void insertUser(User user) {

		Session session = null;

		try {

			session = factory().openSession();
			session.beginTransaction();

			session.save(user);
			
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

	public void removeUser(User user) {

		Session session = null;

		try {

			session = factory().openSession();
			session.beginTransaction();

			session.remove(user);

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

	public void updateUser(User user) {

		Session session = null;

		try {

			session = factory().openSession();
			session.beginTransaction();

			session.update(user);

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

	public List<User> listUser() {

		Session session = null;
		List<User> user = null;

		try {

			session = factory().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();

			CriteriaQuery<User> criteria = construtor.createQuery(User.class);
			Root<User> raizCliente = criteria.from(User.class);

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