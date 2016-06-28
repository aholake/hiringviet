package vn.com.hiringviet.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.response.CommentResponseDTO;
import vn.com.hiringviet.api.dto.response.CommonResponseDTO;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.dto.EndorseDTO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.ResumeDTO;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.EndorseService;
import vn.com.hiringviet.service.FollowService;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.service.ResumeService;
import vn.com.hiringviet.util.Utils;

@Controller
public class ProfileController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private ResumeService resumeService;

	@Autowired
	private EndorseService endorseService;

	@Autowired
	private FollowService followService;

	@RequestMapping(value = "/layouts/profileBanner", method = RequestMethod.GET)
	public String goProfileBanner(Model model, HttpSession session) {

		return "/layouts/profile_banner";
	}

	@RequestMapping(value = "/layouts/profileHeader", method = RequestMethod.GET)
	public String goProfileHeader(Model model, HttpSession session) {

		return "/layouts/profile_header";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String goProfilePage(@RequestParam("memberId") Integer memberId, Model model, HttpSession session) {

		Member member = memberService.getMemberByID(memberId);
		model.addAttribute("member", member);

		return "/profile";
	}

	@RequestMapping(value = "/profile/addSkills", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO addSkills(@RequestBody Set<SkillDTO> skillDTOs, HttpSession session) {

		CommonResponseDTO commonResponseDTO = new CommentResponseDTO();

		Account account = LoginController.getAccountSession(session);
		if (!memberService.addSkillsOfMember(account.getId(), skillDTOs)) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		}
		commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return commonResponseDTO;
	}

	@RequestMapping(value = "/profile/deleteSkillOfProfile", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO deleteSkillOfProfile(@RequestBody ResumeDTO resumeDTO, HttpSession session) {

		CommonResponseDTO commonResponseDTO = new CommentResponseDTO();

		Account account = LoginController.getAccountSession(session);

		if (account.getId().equals(resumeDTO.getAccountId())) {
			if (resumeService.deleteSkillOfProfile(resumeDTO)) {
				commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
			}
		}

		commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		return commonResponseDTO;
	}

	@RequestMapping(value = "/profile/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Member addSkills(@PathVariable("id") Integer id) {
		return memberService.getMemberByID(id);
	}

	@RequestMapping(value = "/profile/endorse/add", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO addEndorse(@RequestBody Integer skillResumeId, HttpSession session) {

		CommonResponseDTO commonResponseDTO = new CommonResponseDTO();

		Account account = LoginController.getAccountSession(session);

		if (Utils.isEmptyObject(account)) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return commonResponseDTO;
		}

		EndorseDTO endorseDTO = new EndorseDTO();
		endorseDTO.setSkillResumeId(skillResumeId);
		endorseDTO.setAccount(account);

		if (endorseService.create(endorseDTO) == 0) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return commonResponseDTO;
		}

		commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return commonResponseDTO;
	}

	@RequestMapping(value = "/profile/endorse/remove", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO removeEndorse(@RequestBody Integer skillResumeId, HttpSession session) {

		CommonResponseDTO commonResponseDTO = new CommonResponseDTO();

		Account account = LoginController.getAccountSession(session);

		if (Utils.isEmptyObject(account)) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return commonResponseDTO;
		}

		commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());

		if (!endorseService.deleteByAccountId(account.getId(), skillResumeId)) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		}

		return commonResponseDTO;
	}


	@RequestMapping(value = "/profile/countNumberOfFollower", method = RequestMethod.POST)
	public @ResponseBody MemberDTO countNumberOfFollower(@RequestBody Integer accountId) {

		MemberDTO memberDTO = memberService.getMemberByAccount(accountId);
		if (!Utils.isEmptyObject(memberDTO)) {
			if (followService.countNumberOfFollower(accountId) > 0) {
				memberDTO.setNumberFollower(followService.countNumberOfFollower(accountId));
			} else {
				memberDTO.setNumberFollower(0L);
			}
		}

		return memberDTO;
	}
}
