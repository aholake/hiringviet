package vn.com.hiringviet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.dto.CountryDTO;
import vn.com.hiringviet.service.CountryService;

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/country/{countryID}")
	public @ResponseBody CountryDTO getCountry(@PathVariable("countryID") Integer countryID) {
		return countryService.getCountryById(countryID);
	}
	
}
