package model.entity.user;

import model.entity.company.Company;
import model.entity.position.Position;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user")
public class User{

//variable
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private  Long id;
	
	@Column(name = "name_user", length = 40, nullable = false, unique = false)
	private String name;
	
	@Column(name = "username_user", length = 20, nullable = false, unique = true)
	private String username;
	
	@Column(name = "password_user", length = 20, nullable = false, unique = false)
	private String password;
	
	@Column(name = "email.user", length =40, nullable = false, unique = true)
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_company")
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_position")
	private Position position;
	
//constructor
	public User() {}
	
	public User(Long id) {
		setId(id);
	}
	
	public User(String name, String username, String password, String email, Company company, Position position) {
		setName(name);
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setCompany(company);
		setPosition(position);
	}
	
	public User(Long id, String name, String username, String password, String email, Company company, Position position) {
		setId(id);
		setName(name);
		setUsername(username);
		setPassword(password);
		setEmail(email);
		setCompany(company);
		setPosition(position);
	}
	
//get
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Company getCompany() {
		return company;
	}

	public Position getPosition() {
		return position;
	}
	
//set
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
}