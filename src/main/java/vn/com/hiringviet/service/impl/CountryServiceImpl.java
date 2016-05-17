package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CountryDAO;
import vn.com.hiringviet.model.Country;
import vn.com.hiringviet.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryDAO countryDAO;
	
	@Override
	public Country getCountryById(int id) {
		// TODO Auto-generated method stub
		return countryDAO.findOne(id);
	}

	@Override
	public List<Country> getCountryList() {
		// TODO Auto-generated method stub
		return countryDAO.findAll();
	}

	@Override
	public long addCountry(Country country) {
		// TODO Auto-generated method stub
		return countryDAO.create(country);
	}

}
