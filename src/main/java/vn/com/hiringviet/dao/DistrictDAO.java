package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.model.District;

public interface DistrictDAO extends CommonDAO<District>{
	public List<District> getDistrictByProvince(int provinceID);
}
