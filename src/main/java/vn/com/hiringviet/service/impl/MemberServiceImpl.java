package vn.com.hiringviet.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.MemberService;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

	@Override
	public boolean addMember(Member member, boolean isCompany) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member checkLogin(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean activeAccount(Integer memberID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member getMemberByteID(Integer memberID) {
		// TODO Auto-generated method stub
		return null;
	}

}
