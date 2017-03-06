package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.ProvinceDAO;
import vn.com.hiringviet.model.Province;
import vn.com.hiringviet.service.ProvinceService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProvinceServiceImpl.
 */
@Service
public class ProvinceServiceImpl implements ProvinceService {
	
	/** The province dao. */
	@Autowired
	private ProvinceDAO provinceDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ProvinceService#getProvinceList()
	 */
	@Override
	public List<Province> getProvinceList() {
		// TODO Auto-generated method stub
		return provinceDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ProvinceService#getProvinceListByCountry(int)
	 */
	@Override
	public List<Province> getProvinceListByCountry(int countryID) {
		// TODO Auto-generated method stub
		return provinceDAO.getProvinceListByCountry(countryID);
	}

}
