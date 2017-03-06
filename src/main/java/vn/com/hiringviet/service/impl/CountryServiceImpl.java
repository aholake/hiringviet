package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CountryDAO;
import vn.com.hiringviet.model.Country;
import vn.com.hiringviet.service.CountryService;

// TODO: Auto-generated Javadoc
/**
 * The Class CountryServiceImpl.
 */
@Service
public class CountryServiceImpl implements CountryService {
	
	/** The country dao. */
	@Autowired
	private CountryDAO countryDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CountryService#getCountryList()
	 */
	@Override
	public List<Country> getCountryList() {
		// TODO Auto-generated method stub
		return countryDAO.findAll();
	}
}
