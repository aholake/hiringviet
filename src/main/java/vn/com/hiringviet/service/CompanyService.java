package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Company;

@Service("companyService")
public interface CompanyService {

	public List<Company> getListCompany(Integer first, Integer max, boolean isCompanyHot);
}
