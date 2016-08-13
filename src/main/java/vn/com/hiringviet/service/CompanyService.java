package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.PostDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;

public interface CompanyService {

	int addCompany(Company company);

	boolean deleteCompany(Company company);

	boolean updateCompany(Company company);
	
	public List<Company> getCompanyList();
	
	public List<Company> getListCompany(Integer first, Integer max, boolean isCompanyHot);

	public Company getCompanyById(int id);

	public List<PostDTO> getListPosts(Integer first, Integer max ,Integer companyId);

	public List<Job> getListJob(Integer first, Integer max ,Integer companyId);
	
	public Company getCompanyByAccount(Account account);

	public List<CompanyDTO> getListCompanySuggest(String keywork);
}
