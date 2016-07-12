package vn.com.hiringviet.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.common.MemberRoleEnum;
import vn.com.hiringviet.common.SkillTypeEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dao.MemberDAO;
import vn.com.hiringviet.dao.SkillDAO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.model.Skill;
import vn.com.hiringviet.model.SkillResume;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.util.Utils;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private SkillDAO skillDAO;

	@Override
	public int addMember(Member member) {
		member.setChangeLog(Utils.createDefaultChangeLog());
		member.getAccount().setRoleID(MemberRoleEnum.USER.getValue());
		member.getAccount().setLocale(ConstantValues.VN_LOCALE);
		return memberDAO.create(member);
	}

	@Override
	public boolean deleteMember(Member member) {
		return memberDAO.delete(member);
	}

	@Override
	public List<Member> getMemberList() {
		return memberDAO.findAll();
	}

	@Override
	public Member getMemberByID(Integer memberID) {
		return memberDAO.findOne(memberID);
	}

	@Override
	public Member getMemberByAccount(Account account) {
		return memberDAO.getMemberByAccount(account);
	}

	@Override
	public boolean addSkillsOfMember(Account account, Set<SkillDTO> skills) {

		Member member = memberDAO.getMemberByAccount(account);

		Set<SkillResume> skillResumeSet = new HashSet<SkillResume>();
		if (!Utils.isEmptyObject(member)) {

			for (SkillDTO skillDTO : skills) {
				Skill skill = new Skill();

				if (Utils.isEmptyNumber(skillDTO.getId())) {
					Skill sk = skillDAO.getSkillByDisplayName(skillDTO.getDisplayName());
					if (!Utils.isEmptyObject(sk)) {
						skill.setId(sk.getId());
						skill.setAddingNumber(sk.getAddingNumber() + 1);
						skill.setType(sk.getType());
					} else {
						skill.setId(skillDTO.getId());
						skill.setAddingNumber(skillDTO.getAddingNumber());
						skill.setType(SkillTypeEnum.DIFFERENT.getValue());
					}
				}

				skill.setDisplayName(skillDTO.getDisplayName());
				SkillResume skillResume = new SkillResume();
				skillResume.setResume(member.getResume());
				skillResume.setSkill(skill);
				skillResumeSet.add(skillResume);
			}
			member.getResume().getSkillResumeSet().addAll(skillResumeSet);

			if (memberDAO.update(member)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public MemberDTO getMemberByAccountId(Integer accountId) {

		return memberDAO.getMemberByAccountId(accountId);
	}

	@Override
	public List<MemberDTO> getListMemberSuggest(String keywork) {

		return memberDAO.getListMemberSuggest(keywork);
	}
}
