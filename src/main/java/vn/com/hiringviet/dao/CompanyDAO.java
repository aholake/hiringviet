package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.model.Company;

public interface CompanyDAO extends CommonDAO<Company>{

	public List<Company> getListCompanyHot(Integer first, Integer max);

	public List<Company> getListCompanySuggest(Integer first, Integer max);
}
