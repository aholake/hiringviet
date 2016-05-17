package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.model.Country;

public interface CountryService {
	public Country getCountryById(int id);
	
	public List<Country> getCountryList();
	
	public long addCountry(Country country);
}
