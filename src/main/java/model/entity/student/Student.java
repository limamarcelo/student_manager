package model.entity.student;

import model.entity.course.Course;

public class Student {
	
	//Variables
	private int id;
	
	private String name;
	
	private String cpf;
	
	private String email;
	
	private Course course;
	
	private Company company;
	
	//Constructors
	public Student() {}
	
	public Student(int id) {
		setId(id);
	}
	
	public Student(String name, String cpf, String email, Course course, Company company) {
		setName(name);
		setCpf(cpf);
		setEmail(email);
		setCourse(course);
		setCompany(company);
	}
	
	public Student(int id, String name, String cpf, String email, Course course, Company company) {
		setId(id);
		setName(name);
		setCpf(cpf);
		setEmail(email);
		setCourse(course);
		setCompany(company);
	}
	
	//Getters & Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	

}
