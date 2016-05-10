package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.MemberDTO;

@Service("memberService")
public interface MemberService {

	public boolean addMember(MemberDTO memberDTO, boolean isCompany);

	public MemberDTO checkLogin(String email, String password);

	public boolean activeAccount(Integer memberID);
}
