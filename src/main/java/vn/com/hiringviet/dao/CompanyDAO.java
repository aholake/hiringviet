package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Posts;

public interface CompanyDAO extends CommonDAO<Company> {

	public List<Company> getListCompanyHot(Integer first, Integer max);

	public List<Company> getListCompanySuggest(Integer first, Integer max);

	public List<Posts> getListPosts(Integer first, Integer max ,Integer companyId);

	public List<Job> getListJob(Integer first, Integer max ,Integer companyId);
}
