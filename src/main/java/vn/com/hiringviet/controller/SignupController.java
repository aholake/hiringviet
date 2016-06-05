package vn.com.hiringviet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Member;

@Controller
public class SignupController {
	@RequestMapping(value = "/register")
	public String goToRegisterOption() {
		return "register-option";
	}

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
}
