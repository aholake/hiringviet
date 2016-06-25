package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.WardDAO;
import vn.com.hiringviet.model.Ward;
import vn.com.hiringviet.service.WardService;

@Service
public class WardServiceImpl implements WardService {
	@Autowired
	private WardDAO wardDAO;

	@Override
	public List<Ward> getWardListByDistrict(int districtID) {
		// TODO Auto-generated method stub
		return wardDAO.getWardListByDistrict(districtID);
	}
	

}
