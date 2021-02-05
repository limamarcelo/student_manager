package model.dao.teacher;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import model.entity.teacher.Teacher;
import model.factory.connection.ConnectionFactory;

public class TeacherDAOImpl implements TeacherDAO {

	private ConnectionFactory factory;

	public TeacherDAOImpl() {
		factory = new ConnectionFactory();
	}

	public void insertTeacher(Teacher teacher) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.save(teacher);

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

	public void removeTeacher(Teacher teacher) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.remove(teacher);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

			sqlException.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	public void updateTeacher(Teacher teacher) {

		Session session = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			session.update(teacher);

			session.getTransaction().commit();

		} catch (Exception sqlException) {

			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}

			sqlException.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	public List<Teacher> listTeacher() {

		Session session = null;
		List<Teacher> subject = null;

		try {

			session = factory.getConnection().openSession();
			session.beginTransaction();

			CriteriaBuilder construtor = session.getCriteriaBuilder();

			CriteriaQuery<Teacher> criteria = construtor.createQuery(Teacher.class);
			Root<Teacher> rootCustomer = criteria.from(Teacher.class);

			criteria.select(rootCustomer);

			subject = session.createQuery(criteria).getResultList();

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

		return subject;

	}
}