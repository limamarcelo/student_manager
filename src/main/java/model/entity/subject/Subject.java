package model.entity.subject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

	
	private static final Long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_subject")
	private Long id;
	
	
	@Column(name = "name_subject", length = 40, nullable = false, unique = false)
	private String name_subject;
	
	
	@Column(name = "teacher_subject")
	private Long teacher_subject;
	
	public Subject() {}

	public Subject(Long id, String name_subject, Long teacher_subject) {

		setId(id);
		setName_subject(name_subject);
		setTeacher_subject(teacher_subject);

	}

	public Subject(String name_subject, Long teacher_subject) {

		setName_subject(name_subject);
		setTeacher_subject(teacher_subject);

	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setName_subject(String name_subject) {
		this.name_subject = name_subject;
	}

	public String getName_subject() {
		return name_subject;
	}

	public void setTeacher_subject(Long teacher_subject) {
		this.teacher_subject = teacher_subject;
	}

	public Long getTeacher_subject() {
		return teacher_subject;
	}
}