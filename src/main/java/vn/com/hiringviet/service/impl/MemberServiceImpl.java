package vn.com.hiringviet.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.common.MemberRoleEnum;
import vn.com.hiringviet.common.StatusRecordEnum;
import vn.com.hiringviet.dao.MemberDAO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.util.DateUtil;

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

	@Override
	public boolean addMember(MemberDTO memberDTO, boolean isCompany) {

		memberDTO.setCreatedAt(DateUtil.now());
		memberDTO.setUpdatedAt(DateUtil.now());
		memberDTO.setStatus(StatusRecordEnum.INACTIVE.getValue());
		memberDTO.setRoleID(MemberRoleEnum.USER.getValue());
		if (isCompany) {
			memberDTO.setRoleID(MemberRoleEnum.COMPANY.getValue());
		}
		Member member = new Member();
		try {
			BeanUtils.copyProperties(member, memberDTO);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return memberDAO.addMember(member);
	}

	@Override
	public boolean activeAccount(Integer memberID) {

		return memberDAO.activeAccount(memberID);
	}
}
