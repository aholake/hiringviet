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

// TODO: Auto-generated Javadoc
/**
 * The Class LoggerServiceImpl.
 */
@Service("loggerService")
public class LoggerServiceImpl implements LoggerService {

	/** The logger dao. */
	@Autowired
	private LoggerDAO loggerDAO;

	/** The account dao. */
	@Autowired
	private AccountDAO accountDAO;

	/** The member dao. */
	@Autowired
	private MemberDAO memberDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.LoggerService#create(java.lang.Integer, java.lang.Integer, java.lang.String, boolean)
	 */
	@Override
	public boolean create(Integer ownerAccountId, Integer guestAccountId, String info, boolean isActivity) {

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

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.LoggerService#jobActivity(vn.com.hiringviet.model.Account, vn.com.hiringviet.model.Account, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public boolean jobActivity(Account ownerAccount, Account guestAccount,
			String image, String info, boolean isActivity) {

		if (ownerAccount != null) {
			Logger logger = new Logger();
			logger.setAccount(guestAccount);
			logger.setDateTime(DateUtil.now());
			logger.setInfo(info);
			logger.setImage(ownerAccount.getAvatarImage());
			logger.setType(isActivity);
			if (loggerDAO.create(logger) > 0) {
				return true;
			}
		}

		return false;
	}

}
