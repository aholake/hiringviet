package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Account;

// TODO: Auto-generated Javadoc
/**
 * The Interface FollowService.
 */
@Service("followService")
public interface FollowService {

	/**
	 * Count number of follower.
	 *
	 * @param accountId the account id
	 * @return the integer
	 */
	public Long countNumberOfFollower(Integer accountId);

	/**
	 * Creates the.
	 *
	 * @param accountFrom the account from
	 * @param accountTo the account to
	 * @return true, if successful
	 */
	public boolean create(Account accountFrom, Account accountTo);
}
