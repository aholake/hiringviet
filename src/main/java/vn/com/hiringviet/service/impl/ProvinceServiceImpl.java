package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.ProvinceDAO;
import vn.com.hiringviet.model.Province;
import vn.com.hiringviet.service.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	private ProvinceDAO provinceDAO;

	@Override
	public List<Province> getProvinceList() {
		// TODO Auto-generated method stub
		return provinceDAO.findAll();
	}

	@Override
	public List<Province> getProvinceListByCountry(int countryID) {
		// TODO Auto-generated method stub
		return provinceDAO.getProvinceListByCountry(countryID);
	}

}
