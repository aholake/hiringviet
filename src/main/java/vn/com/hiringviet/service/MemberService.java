package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Member;

@Service("memberService")
public interface MemberService {

	public boolean addMember(Member member, boolean isCompany);

	public Member checkLogin(String email, String password);

	public boolean activeAccount(Integer memberID);

	public Member getMemberByteID(Integer memberID);
}
