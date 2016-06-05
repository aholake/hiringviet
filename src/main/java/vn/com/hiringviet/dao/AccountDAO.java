package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;

import vn.com.hiringviet.model.Account;

@Repository
public interface AccountDAO {

	public Account checkLogin(String email, String password);
	
	public boolean isExistedAccount(String email);
}
