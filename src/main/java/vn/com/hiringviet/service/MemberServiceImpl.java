package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.hiringviet.dao.MemberDAO;
import vn.com.hiringviet.model.Member;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		return memberDao.getMemberList();
	}

}
