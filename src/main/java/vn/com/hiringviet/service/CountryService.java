package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.dto.CountryDTO;
import vn.com.hiringviet.model.Country;

public interface CountryService {
	public CountryDTO getCountryById(int id);
	
//	public List<CountryDTO> getCountryList();
//	
//	public long addCountry(CountryDTO countryDTO);
}
