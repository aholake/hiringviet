package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("loggerService")
@Transactional
public interface LoggerService {

	public boolean create(Integer ownerAccountId, Integer guestAccountId, String image, String info);
}
