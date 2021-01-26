package model.entity.course;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.security.auth.Subject;

@Entity
@Table(name = "course")
public class Course {
	
	//Variables
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "id_course")
			private Long id;
			
			@Column(name = "name_course", length=20, nullable = false, unique = false)
			private String name;

			@OneToMany(fetch = FetchType.LAZY,mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
			private List<Subject> subjects = new ArrayList<Subject>();
			
	
	//Constructors
	public Course() {}
	
	public Course(int id) {
		setId(id);
	}
	
	public Course(String name, Subject subject) {
		setName(name);
		setSubject(subject);
	}
	
	public Course(int id, String name, Subject subject) {
		setId(id);
		setName(name);
		setSubject(subject);
	}
	
	
	//Getters & Setters

	public int getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	
	
	
}
