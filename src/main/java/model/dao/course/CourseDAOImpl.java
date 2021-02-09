package model.dao.course;

import org.hibernate.Session;

import model.entity.course.Course;
import model.factory.connection.ConnectionFactory;

public class CourseDAOImpl implements CourseDAO {

	private ConnectionFactory factory;
	
	public CourseDAOImpl() {
		factory = new ConnectionFactory();
	}
	
	public void insertCourse(Course course) {
		
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

	
	public void removeCourse(Course course) {
		
		
	}

	
	public void updateCourse(Course course) {
		
	}

	
}
