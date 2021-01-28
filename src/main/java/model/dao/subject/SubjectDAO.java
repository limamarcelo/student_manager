package model.dao.subject;

import antlr.collections.List;
import model.entity.subject.Subject;

public interface SubjectDAO {
	
	void insertSubject(Subject subject);
	
	void removeSubject(Subject subject);
		
	void updateSubject(Subject subject);
		
	List<Subject> listSubject();
}
