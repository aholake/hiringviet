package vn.com.hiringviet.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.MemberDAO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.MemberService;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberDTO checkLogin(String email, String password) {

		Member member = memberDAO.checkLogin(email, password);
		MemberDTO memberDTO = new MemberDTO();

		try {
			BeanUtils.copyProperties(memberDTO, member);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return memberDTO;
	}
}
