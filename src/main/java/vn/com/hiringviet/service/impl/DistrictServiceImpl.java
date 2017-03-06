package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.DistrictDAO;
import vn.com.hiringviet.model.District;
import vn.com.hiringviet.service.DistrictService;

// TODO: Auto-generated Javadoc
/**
 * The Class DistrictServiceImpl.
 */
@Service
public class DistrictServiceImpl implements DistrictService {

	/** The district dao. */
	@Autowired
	private DistrictDAO districtDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.DistrictService#getDistrictByProvince(int)
	 */
	@Override
	public List<District> getDistrictByProvince(int provinceID) {
		return districtDAO.getDistrictByProvince(provinceID);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.DistrictService#getDistrictById(int)
	 */
	@Override
	public District getDistrictById(int id) {
		return districtDAO.findOne(id);
	}

}
