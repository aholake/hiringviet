package vn.com.hiringviet.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.ProvinceDAO;
import vn.com.hiringviet.dto.ProvinceDTO;
import vn.com.hiringviet.model.Province;
import vn.com.hiringviet.service.ProvinceService;

@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {

	@Autowired
	private ProvinceDAO provinceDAO;

	@Override
	public boolean addProvince(ProvinceDTO provinceDTO) {

		Province province = new Province();
		try {
			BeanUtils.copyProperties(province, provinceDTO);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return provinceDAO.addProvince(province);
	}

}
