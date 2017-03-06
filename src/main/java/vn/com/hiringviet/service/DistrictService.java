package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.model.District;

// TODO: Auto-generated Javadoc
/**
 * The Interface DistrictService.
 */
public interface DistrictService {
	
	/**
	 * Gets the district by province.
	 *
	 * @param provinceID the province id
	 * @return the district by province
	 */
	public List<District> getDistrictByProvince(int provinceID);
	
	/**
	 * Gets the district by id.
	 *
	 * @param id the id
	 * @return the district by id
	 */
	public District getDistrictById(int id);
}
