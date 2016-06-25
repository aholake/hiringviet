package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.model.Ward;

public interface WardService {
	public List<Ward> getWardListByDistrict(int districtID);
}
