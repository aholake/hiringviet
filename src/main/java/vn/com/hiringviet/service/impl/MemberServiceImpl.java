package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.MemberDAO;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public int addMember(Member member) {
		// TODO Auto-generated method stub
		return memberDAO.create(member);
	}

	@Override
	public boolean deleteMember(Member member) {
		// TODO Auto-generated method stub
		return memberDAO.delete(member);
	}

	@Override
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		return memberDAO.findAll();
	}

	@Override
	public Member getMemberByID(Integer memberID) {
		// TODO Auto-generated method stub
		return memberDAO.findOne(memberID);
	}
}
