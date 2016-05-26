package vn.com.hiringviet.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CountryDAO;
import vn.com.hiringviet.dto.CountryDTO;
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
		CountryDTO countryDTO = modelMapper.map(country, CountryDTO.class);
		return countryDTO;
	}
}
