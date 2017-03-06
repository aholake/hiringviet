package vn.com.hiringviet.service.impl;

import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.dao.AccountDAO;
import vn.com.hiringviet.dto.AccountDTO;
import vn.com.hiringviet.dto.LoggerDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.util.FileUtil;
import vn.com.hiringviet.util.TimeUtil;

import com.google.appengine.api.ThreadManager;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountServiceImpl.
 */
@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(AccountServiceImpl.class);

	/** The account dao. */
	@Autowired
	private AccountDAO accountDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#checkLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public Account checkLogin(String email, String password) {

		return accountDAO.checkLogin(email, password);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#isExistedAccount(java.lang.String)
	 */
	@Override
	public boolean isExistedAccount(String email) {
		return accountDAO.isExistedAccount(email);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#getAccountByEmail(java.lang.String)
	 */
	@Override
	public Account getAccountByEmail(String email) {
		return accountDAO.getAccountByEmail(email);
	}

	/**
	 * Gets the account dao.
	 *
	 * @return the account dao
	 */
	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	/**
	 * Sets the account dao.
	 *
	 * @param accountDAO the new account dao
	 */
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#trackAccountAfterRegister(vn.com.hiringviet.model.Account)
	 */
	@Override
	public void trackAccountAfterRegister(final Account account) {
		ThreadManager.createBackgroundThread(new Runnable() {

			@Override
			public void run() {
				try {
					Properties configProperties = FileUtil.getConfigProperties();
					long countTime = TimeUtil.convertMinuteToSecond(Integer
							.parseInt(configProperties
									.getProperty("time.inactive")));
					Thread.sleep(countTime);
					Account checkedAccount = getAccountById(account.getId());
					if (!checkedAccount.getActiveUrl().isEmpty()
							&& checkedAccount.getStatus().equals(
									StatusEnum.INACTIVE)) {
						accountDAO.delete(checkedAccount);
						LOGGER.info("Account has been deleted");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#activeAccount(java.lang.String)
	 */
	@Override
	public void activeAccount(String activeCode) throws Exception {
		Account account = accountDAO.getAccountByActiveUrl(activeCode);
		if (!account.getActiveUrl().isEmpty()
				&& account.getStatus().equals(StatusEnum.INACTIVE)) {
			account.setActiveUrl(null);
			account.setStatus(StatusEnum.ACTIVE);
			accountDAO.update(account);
		} else {
			throw new Exception("Account has been active already");
		}

	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#getAccountById(int)
	 */
	@Override
	public Account getAccountById(int id) {
		return accountDAO.findOne(id);
	}

	/**
	 * Delete account.
	 *
	 * @param account the account
	 */
	public void deleteAccount(Account account) {
		accountDAO.delete(account);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#updateAccount(vn.com.hiringviet.model.Account)
	 */
	@Override
	public boolean updateAccount(Account account) {

		return accountDAO.update(account);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#getFollowList(java.lang.String)
	 */
	@Override
	public List<AccountDTO> getFollowList(String accountId) {

		return accountDAO.getFollowList(accountId);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#updateEmail(java.lang.Integer, java.lang.String)
	 */
	@Override
	public boolean updateEmail(Integer accountId, String email) {

		return accountDAO.updateEmail(accountId, email);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#updateLocale(java.lang.Integer, java.lang.String)
	 */
	@Override
	public boolean updateLocale(Integer accountId, String locale) {

		return accountDAO.updateLocale(accountId, locale);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#hasFollow(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public boolean hasFollow(Integer fromAccountId, Integer toAccountId) {
		return accountDAO.hasFollow(fromAccountId, toAccountId);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#getListLogger(java.lang.Integer)
	 */
	@Override
	public List<LoggerDTO> getListLogger(Integer accountId) {
		return accountDAO.getListLogger(accountId);
	}
	
	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.AccountService#getAccountByActiveCode(java.lang.String)
	 */
	@Override
	public Account getAccountByActiveCode(String activeCode) {
		return accountDAO.getAccountByActiveUrl(activeCode);
	}
}
