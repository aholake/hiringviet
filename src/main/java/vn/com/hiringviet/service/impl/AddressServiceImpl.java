package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Address;
import vn.com.hiringviet.model.District;
import vn.com.hiringviet.service.AddressService;
import vn.com.hiringviet.service.CountryService;
import vn.com.hiringviet.service.DistrictService;
import vn.com.hiringviet.service.ProvinceService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private DistrictService districtService;

	@Autowired
	private ProvinceService provinceService;

	@Autowired
	private CountryService countryService;

	@Override
	public Address getFullAddressBaseOnId(Address pureAddress) {
		Address address = new Address();
		address.setExplicitAddress(pureAddress.getExplicitAddress());

		District district = districtService.getDistrictById(pureAddress
				.getDistrict().getId());

		address.setDistrict(district);
		return address;
	}

}
