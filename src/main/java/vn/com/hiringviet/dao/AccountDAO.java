package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.com.hiringviet.dto.AccountDTO;
import vn.com.hiringviet.dto.LoggerDTO;
import vn.com.hiringviet.model.Account;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccountDAO.
 */
@Repository
public interface AccountDAO extends CommonDAO<Account> {

	/**
	 * Check login.
	 *
	 * @param email the email
	 * @param password the password
	 * @return the account
	 */
	public Account checkLogin(String email, String password);
	
	/**
	 * Checks if is existed account.
	 *
	 * @param email the email
	 * @return true, if is existed account
	 */
	public boolean isExistedAccount(String email);
	
	/**
	 * Gets the account by email.
	 *
	 * @param email the email
	 * @return the account by email
	 */
	public Account getAccountByEmail(String email);
	
	/**
	 * Gets the account by active url.
	 *
	 * @param activeCode the active code
	 * @return the account by active url
	 */
	public Account getAccountByActiveUrl(String activeCode);

	/**
	 * Gets the follow list.
	 *
	 * @param accountId the account id
	 * @return the follow list
	 */
	public List<AccountDTO> getFollowList(String accountId);

	/**
	 * Update email.
	 *
	 * @param accountId the account id
	 * @param email the email
	 * @return true, if successful
	 */
	public boolean updateEmail(Integer accountId, String email);

	/**
	 * Update locale.
	 *
	 * @param accountId the account id
	 * @param locale the locale
	 * @return true, if successful
	 */
	public boolean updateLocale(Integer accountId, String locale);

	/**
	 * Checks for follow.
	 *
	 * @param fromAccountId the from account id
	 * @param toAccountIds the to account ids
	 * @return true, if successful
	 */
	public boolean hasFollow(Integer fromAccountId, Integer toAccountIds);

	/**
	 * Gets the list logger.
	 *
	 * @param accountId the account id
	 * @return the list logger
	 */
	public List<LoggerDTO> getListLogger(Integer accountId);
}
