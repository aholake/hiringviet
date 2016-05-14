package vn.com.hiringviet.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.ApplyDAO;
import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.service.ApplyService;

@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

	@Autowired
	private ApplyDAO applyDAO;

	@Override
	public ApplyDTO getApplyByID(Integer applyID) {

		ApplyDTO applyDTO = new ApplyDTO();

		Apply apply = applyDAO.getApplyByID(applyID);

		try {
			BeanUtils.copyProperties(applyDTO, apply);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return applyDTO;
	}

	@Override
	public void addApply(ApplyDTO applyDTO) {

		Apply apply = new Apply();
		try {
			BeanUtils.copyProperties(apply, applyDTO);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		applyDAO.addApply(apply);
	}

	@Override
	public List<ApplyDTO> getAll() {

		return applyDAO.getAll();
	}

}
