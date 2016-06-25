package vn.com.hiringviet.dao;

import java.util.List;

import vn.com.hiringviet.model.Ward;

public interface WardDAO extends CommonDAO<Ward> {
	public List<Ward> getWardListByDistrict(int districtID);
}
