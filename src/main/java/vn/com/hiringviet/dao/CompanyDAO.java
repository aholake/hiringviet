package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Company;

@Repository
@Transactional
public interface CompanyDAO extends CommonDAO<Company>{

	public List<Company> getListCompanyHot(Integer first, Integer max);

	public List<Company> getListCompanySuggest(Integer first, Integer max);
}
