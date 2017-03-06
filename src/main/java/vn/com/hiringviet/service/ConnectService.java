package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Connect;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConnectService.
 */
@Service("connectService")
public interface ConnectService {

	/**
	 * Gets the connect by member id.
	 *
	 * @param formMemberId the form member id
	 * @param toMemberId the to member id
	 * @return the connect by member id
	 */
	public Connect getConnectByMemberId(Integer formMemberId, Integer toMemberId);
}
