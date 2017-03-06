package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.dto.AccountDTO;
import vn.com.hiringviet.dto.LoggerDTO;
import vn.com.hiringviet.model.Account;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccountService.
 */
public interface AccountService {

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
	 * Track account after register.
	 *
	 * @param account the account
	 */
	public void trackAccountAfterRegister(Account account);

	/**
	 * Active account.
	 *
	 * @param randomText the random text
	 * @throws Exception the exception
	 */
	public void activeAccount(String randomText) throws Exception;

	/**
	 * Gets the account by id.
	 *
	 * @param id the id
	 * @return the account by id
	 */
	public Account getAccountById(int id);

	/**
	 * Update account.
	 *
	 * @param account the account
	 * @return true, if successful
	 */
	public boolean updateAccount(Account account);

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
	 * @param toAccountId the to account id
	 * @return true, if successful
	 */
	public boolean hasFollow(Integer fromAccountId, Integer toAccountId);

	/**
	 * Gets the list logger.
	 *
	 * @param accountId the account id
	 * @return the list logger
	 */
	public List<LoggerDTO> getListLogger(Integer accountId);
	
	/**
	 * Gets the account by active code.
	 *
	 * @param activeCode the active code
	 * @return the account by active code
	 */
	Account getAccountByActiveCode(String activeCode);
}
