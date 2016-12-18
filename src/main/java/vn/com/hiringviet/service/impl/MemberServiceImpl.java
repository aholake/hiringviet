package vn.com.hiringviet.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.common.AccountRoleEnum;
import vn.com.hiringviet.common.SkillTypeEnum;
import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.converter.MemberConverter;
import vn.com.hiringviet.dao.MemberDAO;
import vn.com.hiringviet.dao.SkillDAO;
import vn.com.hiringviet.dto.MemberAdminTableDTO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Connect;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.model.Skill;
import vn.com.hiringviet.model.SkillResume;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.MailService;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.util.FileUtil;
import vn.com.hiringviet.util.SecurityUtil;
import vn.com.hiringviet.util.TextGenerator;
import vn.com.hiringviet.util.Utils;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	private static final Logger LOGGER = Logger
			.getLogger(MemberServiceImpl.class);
	@Autowired
	private MemberDAO memberDAO;

	@Autowired
	private SkillDAO skillDAO;

	@Autowired
	private MailService mailService;

	@Autowired
	private AccountService accountService;

	private Properties configProperties = FileUtil.getProperties();

	@Override
	public int addMember(Member member) {
		String encryptPassword = SecurityUtil.encodeStringToBase64(member
				.getAccount().getPassword());
		member.getAccount().setPassword(encryptPassword);
		member.setChangeLog(Utils.createDefaultChangeLog());
		member.getAccount().setUserRole(AccountRoleEnum.USER);
		member.getAccount().setLocale(ConstantValues.VN_LOCALE);
		member.getAccount().setStatus(StatusEnum.INACTIVE);
		member.getAccount()
				.setActiveUrl(TextGenerator.generateRandomString(11));
		int memberId = memberDAO.create(member);
		if (memberId > 0) {
			final Account account = getMemberByID(memberId).getAccount();
			sendActiveAccountEmail(account);
			accountService.trackAccountAfterRegister(account);
		}
		LOGGER.info("insert new member successfully");
		return memberId;
	}

	private void sendActiveAccountEmail(Account account) {
		String randomString = account.getId()
				+ TextGenerator
						.generateRandomString(TextGenerator.RANDOM_ACTIVE_STRING_LENGTH);

		// Send email active account
		String activeUrl = MessageFormat
				.format(configProperties.getProperty("url.activeAccount"),
						randomString);

		LOGGER.info("active code: " + activeUrl);
		// mailService.sendMail(account.getEmail(), "active account",
		// activeUrl);
	}

	@Override
	public boolean deleteMember(int id) {
		Member member = memberDAO.findOne(id);
		if (member != null) {
			return memberDAO.delete(member);
		}
		return false;
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
					Skill sk = skillDAO.getSkillByDisplayName(skillDTO
							.getDisplayName());
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

	@Override
	public void addConnect(Member formMember, Integer toMemberId) {

		Member toMember = memberDAO.findOne(toMemberId);

		Connect connect = new Connect();
		connect.setFromMember(formMember);
		connect.setToMember(toMember);
		connect.setChangeLog(Utils.generatorChangeLog());
		connect.getChangeLog().setStatus(StatusEnum.INACTIVE);
		memberDAO.addConnect(connect);
	}

	@Override
	public List<MemberAdminTableDTO> getListMemberForAdminPage() {
		List<MemberAdminTableDTO> adminTableDTOs = new ArrayList<MemberAdminTableDTO>();
		List<Member> members = getMemberList();
		LOGGER.info(members.size());
		for (Member member : members) {
			LOGGER.info(member.getId());
			adminTableDTOs.add(MemberConverter
					.convertToMemberAdminTableDTO(member));
		}
		return adminTableDTOs;
	}

	@Override
	public boolean updateMember(Member member) {
		try {
			memberDAO.update(member);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
