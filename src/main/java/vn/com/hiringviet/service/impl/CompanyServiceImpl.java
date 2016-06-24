package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CompanyDAO;
import vn.com.hiringviet.model.ChangeLog;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Posts;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.util.Utils;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companyDAO;

	@Override
	public int addCompany(Company company) {
		ChangeLog changeLog = Utils.createDefaultChangeLog();
		company.setChangeLog(changeLog);
		return companyDAO.create(company);
	}

	@Override
	public boolean deleteCompany(Company company) {
		return companyDAO.delete(company);
	}

	@Override
	public boolean updateCompany(Company company) {
		
		return companyDAO.update(company);
	}

	@Override
	public List<Company> getCompanyList() {
		
		return companyDAO.findAll();
	}

	@Override
	public List<Company> getListCompany(Integer first, Integer max, boolean isCompanyHot) {

		if (isCompanyHot) {
			return companyDAO.getListCompanyHot(first, max);
		} else {
			return companyDAO.getListCompanySuggest(first, max);
		}
	}

	public Company findOne(Integer id) {

		return companyDAO.findOne(id);
	}

	@Override
	public List<Posts> getListPosts(Integer first, Integer max,
			Integer companyId) {
		
		return companyDAO.getListPosts(first, max, companyId);
	}

	@Override
	public List<Job> getListJob(Integer first, Integer max, Integer companyId) {
		return companyDAO.getListJob(first, max, companyId);
	}

}
