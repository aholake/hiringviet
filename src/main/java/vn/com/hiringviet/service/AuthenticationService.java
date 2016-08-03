package vn.com.hiringviet.service;

import vn.com.hiringviet.dto.SecurityAccount;

public interface AuthenticationService {
	public SecurityAccount getSecurityAccountAfterLogin();
}
