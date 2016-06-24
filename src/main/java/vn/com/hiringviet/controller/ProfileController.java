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
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.response.CommentResponseDTO;
import vn.com.hiringviet.api.dto.response.CommonResponseDTO;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.MemberService;

@Controller
public class ProfileController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/layouts/profileBanner", method = RequestMethod.GET)
	public String goProfileBanner(Model model, HttpSession session) {

		return "/layouts/profile_banner";
	}

	@RequestMapping(value = "/layouts/profileHeader", method = RequestMethod.GET)
	public String goProfileHeader(Model model, HttpSession session) {

		return "/layouts/profile_header";
	}

	@RequestMapping(value = "/profile/{memberId}", method = RequestMethod.GET)
	public String goProfilePage(@PathVariable("memberId") Integer memberId, Model model, HttpSession session) {

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
}
