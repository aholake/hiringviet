package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.model.District;

public interface DistrictService {
	public List<District> getDistrictByProvince(int provinceID);
}
