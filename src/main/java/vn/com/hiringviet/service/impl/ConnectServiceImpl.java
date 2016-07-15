package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.ConnectDAO;
import vn.com.hiringviet.model.Connect;
import vn.com.hiringviet.service.ConnectService;

@Service("connectService")
public class ConnectServiceImpl implements ConnectService {

	@Autowired
	private ConnectDAO connectDAO;

	@Override
	public Connect getConnectByMemberId(Integer formMemberId, Integer toMemberId) {

		return connectDAO.getConnectByMemberId(formMemberId, toMemberId);
	}

	

}
