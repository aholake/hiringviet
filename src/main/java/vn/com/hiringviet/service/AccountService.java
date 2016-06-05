package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Account;

@Service("AccountService")
public interface AccountService {

	public Account checkLogin(String email, String password);
}
