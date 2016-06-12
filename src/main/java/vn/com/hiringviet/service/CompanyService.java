package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.model.Company;

public interface CompanyService {
	int addCompany(Company company);

	boolean deleteCompany(Company company);

	boolean updateCompany(Company company);
	
	List<Company> getCompanyList();
	
	List<Company> getListCompany(Integer first, Integer max, boolean isCompanyHot);

}
