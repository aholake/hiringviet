package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.FollowDAO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Follow;
import vn.com.hiringviet.service.FollowService;
import vn.com.hiringviet.util.Utils;

// TODO: Auto-generated Javadoc
/**
 * The Class FolllowServiceImpl.
 */
@Service("followService")
public class FollowServiceImpl implements FollowService {

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

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.FollowService#create(vn.com.hiringviet.model.Account, vn.com.hiringviet.model.Account)
	 */
	@Override
	public boolean create(Account accountFrom, Account accountTo) {

		Follow follow = new Follow();
		follow.setFromAccount(accountFrom);
		follow.setToAccount(accountTo);
		follow.setChangeLog(Utils.generatorChangeLog());
		if (followDAO.create(follow) > 0) {
			return true;
		}

		return false;
	}

}
