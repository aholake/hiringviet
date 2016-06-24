package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.DistrictDAO;
import vn.com.hiringviet.model.District;
import vn.com.hiringviet.service.DistrictService;

@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictDAO districtDAO;

	@Override
	public List<District> getDistrictByProvince(int provinceID) {
		// TODO Auto-generated method stub
		return districtDAO.getDistrictByProvince(provinceID);
	}

}
