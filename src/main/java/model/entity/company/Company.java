package model.entity.company;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_company")
	private long id_company;

	@Column(name = "name_company", length = 40, nullable = false, unique = false)
	private String name_company;
	
	@Column(name = "cnpj_company", length = 18, nullable = false, unique = false)
	private String cnpj_company;
	
	@Column(name = "email= company", length = 40, nullable = false, unique = false)
	private String email_company;
	
	@Column(name = "address_company", length = 40, nullable = false, unique = false)
	private String address_company;
	
	@Column(name = "phone_company", length = 15, nullable = false, unique = false)
	private long phone_company;
	
	public Company() {}

	public Company(long id_company, String name_company, String cnpj_company, String email_company,
			String address_company, long phone_company) {

		setId_company(id_company);
		setName_company(name_company);
		setCnpj_company(cnpj_company);
		setEmail_company(email_company);
		setAddress_company(address_company);
		setPhone_company(phone_company);

	}

	public Company(String name_company, String cnpj_company, String email_company, String address_company,
			long phone_company) {

		setName_company(name_company);
		setCnpj_company(cnpj_company);
		setEmail_company(email_company);
		setAddress_company(address_company);
		setPhone_company(phone_company);

	}

	public long getId_company() {
		return id_company;
	}

	public void setId_company(long id_company) {
		this.id_company = id_company;
	}

	public String getName_company() {
		return name_company;
	}

	public void setName_company(String name_company) {
		this.name_company = name_company;
	}

	public String getCnpj_company() {
		return cnpj_company;
	}

	public void setCnpj_company(String cnpj_company) {
		this.cnpj_company = cnpj_company;
	}

	public String getEmail_company() {
		return email_company;
	}

	public void setEmail_company(String email_company) {
		this.email_company = email_company;
	}

	public String getAddress_company() {
		return address_company;
	}

	public void setAddress_company(String address_company) {
		this.address_company = address_company;
	}

	public long getPhone_company() {
		return phone_company;
	}

	public void setPhone_company(long phone_company) {
		this.phone_company = phone_company;
	}
}