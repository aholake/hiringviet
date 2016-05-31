package vn.com.hiringviet.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.ApplyDAO;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.service.ApplyService;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

	@Override
	public Apply getApplyByID(Integer applyID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addApply(Apply apply) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Apply> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
