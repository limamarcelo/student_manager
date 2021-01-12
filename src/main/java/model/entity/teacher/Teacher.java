package model.entity.teacher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_teacher")
	private  int id;
	
	@Column(name = "name_teacher", length = 25, nullable = false, unique = false)
	private String name;
	
	@Column(name = "cpf_teacher", length = 11, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "email_teacher", length = 50, nullable = false, unique = true)
	private String email;
	
	@Column(name = "subject_teacher", length = 50, nullable = true, unique = false)
	private String subject;
	
	public Teacher() {}
	
	public Teacher(String name, String cpf, String email, String subject) {
		setName(name);
		setCpf(cpf);
		setEmail(email);
		setSubject(subject);
	}
	
	public Teacher(int id, String name, String cpf, String email, String subject) {
		setId(id);
		setName(name);
		setCpf(cpf);
		setEmail(email);
		setSubject(subject);
	}
	
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
