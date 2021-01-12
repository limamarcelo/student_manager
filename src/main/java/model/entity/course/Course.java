package model.entity.course;

public class Course {
	
	//Variables
	
	private int id;
	
	private String name;

	private Subject subject;
	
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

	public void setId(int id) {
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
