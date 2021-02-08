package model.entity.teacher;

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
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_teacher")
	private Long id;
	
	@Column(name = "name_teacher", length = 25, nullable = false, unique = false)
	private String name;

	@Column(name = "cpf_teacher", length = 11, nullable = false, unique = true)
	private String cpf;

	@Column(name = "email_teacher", length = 50, nullable = false, unique = true)
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Subject> subjects = new ArrayList<Subject>();

	public Teacher() {
	}

	public Teacher(String name, String cpf, String email, List<Subject> subject) {
		setName(name);
		setCpf(cpf);
		setEmail(email);

	}


	public Teacher(int id, String name, String cpf, String email, List<Subject> subjects) {

	
	public Teacher(Long id, String name, String cpf, String email, String subject) {

		setId(id);
		setName(name);
		setCpf(cpf);
		setEmail(email);

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {

	
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

	public void addSubject(Subject subject) {
		subject.add(subject);
	}

	public void removeSubject(Subject subject) {
		subject.remove(subject);
	}

}
