package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.model.Province;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProvinceService.
 */
public interface ProvinceService {
	
	/**
	 * Gets the province list.
	 *
	 * @return the province list
	 */
	public List<Province> getProvinceList();

	/**
	 * Gets the province list by country.
	 *
	 * @param countryID the country id
	 * @return the province list by country
	 */
	public List<Province> getProvinceListByCountry(int countryID);
}
