package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Account;

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

	public boolean create(Account accountFrom, Account accountTo);
}
