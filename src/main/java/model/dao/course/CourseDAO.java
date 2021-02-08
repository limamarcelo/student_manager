package model.dao.course;

import org.hibernate.mapping.List;

import model.entity.course.Course;

public interface CourseDAO {
	
	void insertCourse(Course course);
	
	void removeCourse(Course course);
	
	void updateCourse(Course course);
	
	void insert
	
	List<Course> listCourse();

	
}
