package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.FollowDAO;
import vn.com.hiringviet.service.FollowService;

/**
 * The Class FolllowServiceImpl.
 */
@Service("followService")
public class FolllowServiceImpl implements FollowService {

	/** The follow dao. */
	@Autowired
	private FollowDAO followDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.FollowService#countNumberOfFollower(java.lang.Integer)
	 */
	@Override
	public Long countNumberOfFollower(Integer accountId) {

		return followDAO.countNumberOfFollower(accountId);
	}

}
