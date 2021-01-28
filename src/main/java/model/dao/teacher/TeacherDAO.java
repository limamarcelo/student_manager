package model.dao.teacher;

import antlr.collections.List;
import model.entity.teacher.Teacher;

public interface TeacherDAO {

	void insertTeaher(Teacher teacher);
	
	void removeTeacher(Teacher teacher);
	
	void updateTeacher(Teacher teacher);
	
	List<Teacher> listTeacher();
	
	
}
