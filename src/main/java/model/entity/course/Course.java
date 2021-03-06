package model.entity.course;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.mapping.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import model.entity.subject.Subject;

@Entity
@Table(name = "course")
public class Course {

	// Variables

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_course")
	private Long id;

	@Column(name = "name_course", length = 20, nullable = false, unique = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Subject> subjects = new ArrayList<Subject>();

	// Constructors
	public Course() {
	}

	public Course(Long id) {
		setId(id);
	}

	public Course(String name, Subject subjects) {
		setName(name);
		setSubjects(subjects);
	}

	public Course(Long id, String name, Subject subjects) {
		setId(id);
		setName(name);
		setSubjects(subjects);
	}

	// Getters & Setters

	public Long getId() {
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

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}


	public void addSubject(Subject subject) {
		subject.add(subject);
	}

	public void removeSubject(Subject subject) {
		subject.remove(subject);
	}


}



