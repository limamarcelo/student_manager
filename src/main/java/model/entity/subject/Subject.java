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
public class Subject {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_subject")
	private Long id_subject;
	
	
	@Column(name = "name_subject", length = 40, nullable = false, unique = false)
	private String name_subject;
	
	
	public Subject() {}

	public Subject(Long id_subject, String name_subject, Long teacher_subject) {

		setId_subject(id_subject);
		setName_subject(name_subject);
		setTeacher_subject(teacher_subject);

	}

	public Subject(String name_subject, Long teacher_subject) {

		setName_subject(name_subject);
		setTeacher_subject(teacher_subject);

	}

	public void setId_subject(Long id_subject) {
		this.id_subject = id_subject;
	}
	
	public Long getId_subject() {
		return id_subject;
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