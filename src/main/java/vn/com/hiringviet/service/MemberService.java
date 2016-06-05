package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Member;

@Service("memberService")
public interface MemberService {

	public int addMember(Member member);
	
	public boolean deleteMember(Member member);
	
	public List<Member> getMemberList();

	public Member getMemberByID(Integer memberID);
	
	public boolean isExistEmail(String email);
}
