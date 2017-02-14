package vn.com.hiringviet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.AccountDAO;
import vn.com.hiringviet.dao.LoggerDAO;
import vn.com.hiringviet.dao.MemberDAO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Logger;
import vn.com.hiringviet.service.LoggerService;
import vn.com.hiringviet.util.DateUtil;
import vn.com.hiringviet.util.Utils;

@Service("loggerService")
public class LoggerServiceImpl implements LoggerService {

	@Autowired
	private LoggerDAO loggerDAO;

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public boolean create(Integer ownerAccountId, Integer guestAccountId, String image, String info, boolean isActivity) {

		MemberDTO member = memberDAO.getMemberByAccountId(guestAccountId);
		Account account = accountDAO.findOne(ownerAccountId);
		if (account != null) {
			Logger logger = new Logger();
	
			logger.setAccount(account);
			logger.setDateTime(DateUtil.now());
			logger.setInfo(Utils.getMessage(info, member.getFirstName() + " " + member.getLastName()));
			logger.setImage(account.getAvatarImage());
			logger.setType(isActivity);
			if (loggerDAO.create(logger) > 0) {
				return true;
			}
		}

		return false;
	}

}
