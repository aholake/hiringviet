package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.model.Province;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProvinceDAO.
 */
public interface ProvinceDAO extends CommonDAO<Province> {

	/**
	 * Gets the province list by country.
	 *
	 * @param countryID the country id
	 * @return the province list by country
	 */
	public List<Province> getProvinceListByCountry(int countryID);
}
