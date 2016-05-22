package vn.com.hiringviet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CountryDAO;
import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.CountryDTO;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Country;
import vn.com.hiringviet.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDAO countryDAO;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CountryDTO getCountryById(int id) {
		Country country = countryDAO.findOne(id);		
		CountryDTO countryDTO = new CountryDTO();
		countryDTO.setCountryID(country.getCountryID());
		countryDTO.setCountryCode(country.getCountryCode());
		List<Company> companyList = country.getCompanyList();
		List<CompanyDTO> companyDTOList = new ArrayList<CompanyDTO>();
		for (Company company : companyList) {
			CompanyDTO companyDTO = new CompanyDTO();
			companyDTO.setCompanyID(company.getCompanyID());
			companyDTOList.add(companyDTO);
		}
		countryDTO.setCompanyList(companyDTOList);
		return countryDTO;
	}
}
