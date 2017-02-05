package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.LoggerDAO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Logger;
import vn.com.hiringviet.service.LoggerService;
import vn.com.hiringviet.util.DateUtil;

@Service("loggerService")
public class LoggerServiceImpl implements LoggerService {

	@Autowired
	private LoggerDAO loggerDAO;

	@Override
	public boolean create(Account account, String image) {

		Logger logger = new Logger();

		logger.setAccount(account);
		logger.setDateTime(DateUtil.now());
		logger.setInfo("Một thành viên vừa Subscribe trang của bạn.");
		logger.setImage(image);

		if (loggerDAO.create(logger) > 0) {
			return true;
		}

		return false;
	}

}
