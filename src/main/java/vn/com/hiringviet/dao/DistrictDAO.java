package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.model.District;

// TODO: Auto-generated Javadoc
/**
 * The Interface DistrictDAO.
 */
public interface DistrictDAO extends CommonDAO<District>{
	
	/**
	 * Gets the district by province.
	 *
	 * @param provinceID the province id
	 * @return the district by province
	 */
	public List<District> getDistrictByProvince(int provinceID);
}
