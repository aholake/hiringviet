package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Account;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoggerService.
 */
@Service("loggerService")
@Transactional
public interface LoggerService {

	/**
	 * Creates the.
	 *
	 * @param ownerAccountId the owner account id
	 * @param guestAccountId the guest account id
	 * @param info the info
	 * @param isActivity the is activity
	 * @return true, if successful
	 */
	public boolean create(Integer ownerAccountId, Integer guestAccountId, String info, boolean isActivity);

	/**
	 * Job activity.
	 *
	 * @param ownerAccount the owner account
	 * @param guestAccount the guest account
	 * @param image the image
	 * @param info the info
	 * @param isActivity the is activity
	 * @return true, if successful
	 */
	public boolean jobActivity(Account ownerAccount, Account guestAccount, String image, String info, boolean isActivity);
}
