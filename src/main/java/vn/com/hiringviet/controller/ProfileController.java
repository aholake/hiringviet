package vn.com.hiringviet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
