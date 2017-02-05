package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Account;

@Service("loggerService")
@Transactional
public interface LoggerService {

	public boolean create(Account account, String image);
}
