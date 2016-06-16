package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CompanyDAO;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Posts;
import vn.com.hiringviet.service.CompanyService;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDAO companyDAO;

	@Override
	public int addCompany(Company company) {
		// TODO Auto-generated method stub
		return companyDAO.create(company);
	}

	@Override
	public boolean deleteCompany(Company company) {
		// TODO Auto-generated method stub
		return companyDAO.delete(company);
	}

	@Override
	public boolean updateCompany(Company company) {
		// TODO Auto-generated method stub
		return companyDAO.update(company);
	}

	@Override
	public List<Company> getCompanyList() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return companyDAO.getListPosts(first, max, companyId);
	}

	@Override
	public List<Job> getListJob(Integer first, Integer max, Integer companyId) {
		// TODO Auto-generated method stub
		return companyDAO.getListJob(first, max, companyId);
	}

}
