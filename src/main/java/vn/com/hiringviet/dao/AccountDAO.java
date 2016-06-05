package vn.com.hiringviet.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Account;

@Repository
@Transactional
public interface AccountDAO {

	public Account checkLogin(String email, String password);
}
