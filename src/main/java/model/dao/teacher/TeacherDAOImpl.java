configuration.addAnnotatedClass(model.entity.subject.Subject.class);package model.dao.teacher;

import org.hibernate.Session;
import org.hibernate.mapping.List;

import model.entity.teacher.Teacher;
import model.factory.connection.ConnectionFactory;

public class TeacherDAOImpl implements TeacherDAO {

	private ConnectionFactory factory;

	public TeacherDAOImpl() {
		factory = new ConnectionFactory();
	}

	public void insertTeaher(Teacher teacher) {

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
		// TODO Auto-generated method stub
		return null;
	}
}