package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Post;

public interface CompanyService {

	int addCompany(Company company);

	boolean deleteCompany(Company company);

	boolean updateCompany(Company company);
	
	List<Company> getCompanyList();
	
	List<Company> getListCompany(Integer first, Integer max, boolean isCompanyHot);

	public Company findOne(Integer id);

	public List<Post> getListPosts(Integer first, Integer max ,Integer companyId);

	public List<Job> getListJob(Integer first, Integer max ,Integer companyId);
}
