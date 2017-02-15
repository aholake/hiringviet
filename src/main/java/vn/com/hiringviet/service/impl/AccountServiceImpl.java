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
import vn.com.hiringviet.util.Utils;

import com.google.appengine.api.ThreadManager;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	private static final Logger LOGGER = Logger.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountDAO accountDAO;

	@Override
	public Account checkLogin(String email, String password) {

		return accountDAO.checkLogin(email, password);
	}

	@Override
	public boolean isExistedAccount(String email) {
		return accountDAO.isExistedAccount(email);
	}

	@Override
	public Account getAccountByEmail(String email) {
		return accountDAO.getAccountByEmail(email);
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

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

	@Override
	public void activeAccount(String activeCode) throws Exception {
		Account account = accountDAO.findOne(Utils
				.getAccountIdFromActiveCode(activeCode));
		if (!account.getActiveUrl().isEmpty()
				&& account.getStatus().equals(StatusEnum.INACTIVE)) {
			account.setActiveUrl(null);
			account.setStatus(StatusEnum.ACTIVE);
			accountDAO.update(account);
		} else {
			throw new Exception("Account has been active already");
		}

	}

	@Override
	public Account getAccountById(int id) {
		return accountDAO.findOne(id);
	}

	public void deleteAccount(Account account) {
		accountDAO.delete(account);
	}

	@Override
	public boolean updateAccount(Account account) {

		return accountDAO.update(account);
	}

	@Override
	public List<AccountDTO> getFollowList(String accountId) {

		return accountDAO.getFollowList(accountId);
	}

	@Override
	public boolean updateEmail(Integer accountId, String email) {

		return accountDAO.updateEmail(accountId, email);
	}

	@Override
	public boolean updateLocale(Integer accountId, String locale) {

		return accountDAO.updateLocale(accountId, locale);
	}

	@Override
	public boolean hasFollow(Integer fromAccountId, Integer toAccountId) {
		return accountDAO.hasFollow(fromAccountId, toAccountId);
	}

	@Override
	public List<LoggerDTO> getListLogger(Integer accountId) {
		return accountDAO.getListLogger(accountId);
	}
}
