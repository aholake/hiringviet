package vn.com.hiringviet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.model.District;
import vn.com.hiringviet.model.Province;
import vn.com.hiringviet.model.Ward;
import vn.com.hiringviet.service.DistrictService;
import vn.com.hiringviet.service.ProvinceService;
import vn.com.hiringviet.service.WardService;

@Controller
public class RestController {
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private DistrictService districtService;
	@Autowired
	private WardService wardService;

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

	@RequestMapping("/rest/getWardsByDistrict")
	public @ResponseBody List<Ward> getWardListByDistrict(
			@RequestBody int districtID) {
		return wardService.getWardListByDistrict(districtID);
	}
}
