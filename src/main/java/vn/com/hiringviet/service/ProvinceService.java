package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.ProvinceDTO;

@Service("provinceService")
public interface ProvinceService {

	public boolean addProvince(ProvinceDTO provinceDTO);
}
