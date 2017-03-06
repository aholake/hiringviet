package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Connect;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConnectDAO.
 */
@Repository
@Transactional
public interface ConnectDAO extends CommonDAO<Connect> {

	/**
	 * Gets the connect by member id.
	 *
	 * @param formMemberId the form member id
	 * @param toMemberId the to member id
	 * @return the connect by member id
	 */
	public Connect getConnectByMemberId(Integer formMemberId, Integer toMemberId);
}
