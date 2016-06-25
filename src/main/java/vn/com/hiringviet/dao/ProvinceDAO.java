package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.model.Province;

public interface ProvinceDAO extends CommonDAO<Province> {
	public List<Province> getProvinceListByCountry(int countryID);
}
