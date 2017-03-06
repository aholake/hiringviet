package vn.com.hiringviet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.model.District;
import vn.com.hiringviet.model.Province;
import vn.com.hiringviet.model.Skill;
import vn.com.hiringviet.service.DistrictService;
import vn.com.hiringviet.service.ProvinceService;
import vn.com.hiringviet.service.SkillService;

// TODO: Auto-generated Javadoc
/**
 * The Class AddressController.
 */
@Controller
public class AddressController {
	
	/** The province service. */
	@Autowired
	private ProvinceService provinceService;
	
	/** The district service. */
	@Autowired
	private DistrictService districtService;

	/** The skill service. */
	@Autowired
	private SkillService skillService;

	/**
	 * Gets the list province by country.
	 *
	 * @param countryID the country id
	 * @return the list province by country
	 */
	@RequestMapping("/rest/getProvincesByCountry")
	public @ResponseBody List<Province> getListProvinceByCountry(
			@RequestBody int countryID) {
		return provinceService.getProvinceListByCountry(countryID);
	}

	/**
	 * Gets the district list by province.
	 *
	 * @param provinceID the province id
	 * @return the district list by province
	 */
	@RequestMapping("/rest/getDistrictsByProvince")
	public @ResponseBody List<District> getDistrictListByProvince(
			@RequestBody int provinceID) {
		return districtService.getDistrictByProvince(provinceID);
	}

	/**
	 * Gets the skills.
	 *
	 * @return the skills
	 */
	@RequestMapping("/rest/getSkillList")
	public @ResponseBody List<Skill> getSkills() {
		return skillService.getSkillList();
	}
}
