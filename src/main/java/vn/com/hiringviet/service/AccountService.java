package vn.com.hiringviet.service;

import java.util.List;

import vn.com.hiringviet.dto.AccountDTO;
import vn.com.hiringviet.dto.LoggerDTO;
import vn.com.hiringviet.model.Account;

public interface AccountService {

	public Account checkLogin(String email, String password);

	public boolean isExistedAccount(String email);

	public Account getAccountByEmail(String email);

	public void trackAccountAfterRegister(Account account);

	public void activeAccount(String randomText) throws Exception;

	public Account getAccountById(int id);

	public boolean updateAccount(Account account);

	public List<AccountDTO> getFollowList(String accountId);

	public boolean updateEmail(Integer accountId, String email);

	public boolean updateLocale(Integer accountId, String locale);

	public boolean hasFollow(Integer fromAccountId, Integer toAccountId);

	public List<LoggerDTO> getListLogger(Integer accountId);
}
