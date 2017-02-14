package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.PostDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;

public interface CompanyDAO extends CommonDAO<Company> {

	public List<Company> getListCompanyHot(Integer first, Integer max);

	public List<Company> getListCompanySuggest(Integer first, Integer max);

	public List<PostDTO> getListPosts(Integer first, Integer max, Integer companyId);

	public List<Job> getListJob(Integer first, Integer max, Integer companyId, boolean getAll);

	public Company getCompanyByAccount(Account account);

	public List<CompanyDTO> getListCompanySuggest(String keywork);

	public List<CompanyDTO> getListCompanyFollow(Integer accountId);
}
