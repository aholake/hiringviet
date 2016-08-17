package vn.com.hiringviet.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.hiringviet.auth.CustomAuthenticationProvider;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.MemberService;

@Controller
public class LoginController {
	private static final Logger LOGGER = Logger
			.getLogger(LoginController.class);

	@Autowired
	private AccountService accountService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	@RequestMapping("/access-denied")
	public String accessDenied() {
		return "access_denied";
	}

	@RequestMapping(value = "/action/login", method = RequestMethod.POST)
	@ResponseBody
	public StatusResponseEnum loginAjax(
			@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		LOGGER.info("email: " + email + " password: " + password);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				email, password);
		try {
			Authentication auth = customAuthenticationProvider
					.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			return StatusResponseEnum.SUCCESS;
		} catch (UsernameNotFoundException e) {
			return StatusResponseEnum.FAIL;
		}
	}

}