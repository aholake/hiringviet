package vn.com.hiringviet.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.MemberService;

@Controller
public class SignupController {
	@Autowired
	private AccountService accountService;

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/register")
	public String goToRegisterOption() {
		return "register-option";
	}

	private Logger Logger = org.apache.log4j.Logger
			.getLogger(SignupController.class);

	@RequestMapping(value = "/register/{type}")
	public ModelAndView goToRegisterPage(@PathVariable("type") String type) {
		if (type.equals("company")) {
			return new ModelAndView("company-register", "newCompany",
					new Company());
		}
		if (type.equals("member")) {
			return new ModelAndView("member-register", "newMember",
					new Member());
		}
		return null;
	}

	@RequestMapping(value = "/rest/saveMember", method = RequestMethod.POST)
	public @ResponseBody String saveNewMember(
			@ModelAttribute("newMember") Member member) {
		Logger.info(member);
		if (memberService.addMember(member) > 0) {
			return "Added successfully";

		}
		return "Add failed";
	}

	@RequestMapping(value = "/rest/checkExistedEmail", method = RequestMethod.POST)
	public @ResponseBody boolean checkExistedEmail(@RequestBody String email) {
		return accountService.isExistedAccount(email);
	}

	@RequestMapping(value = "/rest/addNewMember", method = RequestMethod.POST)
	public @ResponseBody int addNewMember(@RequestBody Member member) {
		System.out.println(member.getAccount().getEmail() + ", "
				+ member.getAccount().getPassword() + ", "
				+ member.getFirstName() + ", " + member.getLastName());
		return memberService.addMember(member);
	}
}
