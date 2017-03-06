package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.ConnectDAO;
import vn.com.hiringviet.model.Connect;
import vn.com.hiringviet.service.ConnectService;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectServiceImpl.
 */
@Service("connectService")
public class ConnectServiceImpl implements ConnectService {

	/** The connect dao. */
	@Autowired
	private ConnectDAO connectDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ConnectService#getConnectByMemberId(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Connect getConnectByMemberId(Integer formMemberId, Integer toMemberId) {

		return connectDAO.getConnectByMemberId(formMemberId, toMemberId);
	}

	

}
