package model.dao.company;



import antlr.collections.List;
import model.entity.company.Company;

public interface CompanyDAO {

	void insertCompany(Company company);
	
	void removeCompany(Company company);
		
	void updateCompany(Company company);
		
	List<Company> listCompany();
	
}
