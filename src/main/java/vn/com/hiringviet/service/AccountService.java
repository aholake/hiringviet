package vn.com.hiringviet.service;

import vn.com.hiringviet.model.Account;

public interface AccountService {

	public Account checkLogin(String email, String password);

	public boolean isExistedAccount(String email);

	public Account getAccountByEmail(String email);

	public void trackAccountAfterRegister(Account account);

	public void activeAccount(String randomText) throws Exception;

	public Account getAccountById(int id);
}
