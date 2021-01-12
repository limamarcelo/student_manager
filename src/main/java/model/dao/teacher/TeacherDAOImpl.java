package model.dao.teacher;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.entity.teacher.Teacher;

public class TeacherDAOImpl implements TeacherDAO{

	public void insertTeaher(Teacher teacher) {
		
		Session sessao = null;

		try {

			sessao = connectDatabase().openSession();
			sessao.beginTransaction();

			sessao.save(teacher);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
		
	}

	public void removeTeacher(Teacher teacher) {
		
		Session session = null;

		try {

			session = connectDatabase().openSession();
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

			session = connectDatabase().openSession();
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

	private SessionFactory connectDatabase() {

		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(model.entity.teacher.Teacher.class);
		configuration.configure("hibernate-cfg.xml");

		ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

		SessionFactory factorySession = configuration.buildSessionFactory(service);

		return factorySession;

	}
	
}
