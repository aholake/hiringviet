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

@Controller
public class AddressController {
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private DistrictService districtService;

	@Autowired
	private SkillService skillService;

	@RequestMapping("/rest/getProvincesByCountry")
	public @ResponseBody List<Province> getListProvinceByCountry(
			@RequestBody int countryID) {
		return provinceService.getProvinceListByCountry(countryID);
	}

	@RequestMapping("/rest/getDistrictsByProvince")
	public @ResponseBody List<District> getDistrictListByProvince(
			@RequestBody int provinceID) {
		return districtService.getDistrictByProvince(provinceID);
	}

	@RequestMapping("/rest/getSkillList")
	public @ResponseBody List<Skill> getSkills() {
		return skillService.getSkillList();
	}
}
