package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.com.hiringviet.dto.AccountDTO;
import vn.com.hiringviet.model.Account;

@Repository
public interface AccountDAO extends CommonDAO<Account> {

	public Account checkLogin(String email, String password);
	
	public boolean isExistedAccount(String email);
	
	public Account getAccountByEmail(String email);
	
	public Account getAccountByActiveUrl(String activeCode);

	public List<AccountDTO> getFollowList(String accountId);

	public boolean updateEmail(Integer accountId, String email);
}
