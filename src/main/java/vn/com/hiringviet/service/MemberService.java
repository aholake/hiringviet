package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.MemberDTO;

@Service("memberService")
public interface MemberService {

	public MemberDTO checkLogin(String email, String password);
}
