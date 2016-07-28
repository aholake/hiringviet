package vn.com.hiringviet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.hiringviet.api.dto.response.AccountDTO;
import vn.com.hiringviet.api.dto.response.CommonResponseDTO;
import vn.com.hiringviet.common.MemberRoleEnum;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.dto.SecurityAccount;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.util.CookieUtil;

@Controller
public class LoginController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	@Qualifier("authenticationManager")
	AuthenticationManager authenticationManager;

	@RequestMapping(value = "/account/checkAccount", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO login(
			@RequestBody AccountDTO accountDTO, HttpServletResponse response,
			HttpSession session) {

		CommonResponseDTO commonResponseDTO = new CommonResponseDTO();
		Account account = accountService.checkLogin(accountDTO.getEmail(),
				accountDTO.getPassword());

		if (account == null) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return commonResponseDTO;
		}

		if (accountDTO.isRemembered()) {
			CookieUtil.createCookie(response, "email", account.getEmail());
			CookieUtil
					.createCookie(response, "password", account.getPassword());
		}

		session.setAttribute("account", account);

		if (MemberRoleEnum.USER == account.getUserRole()) {
			session.setAttribute("memberSession",
					memberService.getMemberByAccount(account));
		} else if (MemberRoleEnum.COMPANY == account.getUserRole()) {
			session.setAttribute("companySession",
					companyService.getCompanyByAccount(account));
		} else {

		}

		commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return commonResponseDTO;
	}

	@RequestMapping(value = "/db", method = RequestMethod.GET)
	public String dbaPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "dba";
	}

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
	public String accessDenied(Model model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			SecurityAccount securityAccount = (SecurityAccount) auth
					.getPrincipal();
			model.addAttribute("account", securityAccount);
		}
		return "access_denied";
	}

	public static Account getAccountSession(HttpSession session) {
		return (Account) session.getAttribute("account");
	}

	public static Member getMemberSession(HttpSession session) {
		return (Member) session.getAttribute("memberSession");
	}

	public static Company getCompanySession(HttpSession session) {
		return (Company) session.getAttribute("companySession");
	}
	

	private String getPrincipal() {
		String email = null;
		Object principle = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principle instanceof UserDetails) {
			email = ((UserDetails) principle).getUsername();
		} else {
			email = principle.toString();
		}
		return email;
	}

	@RequestMapping(value = "/action/login", method = RequestMethod.POST)
	@ResponseBody
	public LoginStatus loginAjax(@RequestParam("email") String email,
			@RequestParam("password") String password) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				email, password);
		try {
			Authentication auth = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			return new LoginStatus(true, "you signed in successfully");
		} catch (BadCredentialsException e) {
			return new LoginStatus(false, "Email or password is not correct");
		}
	}

	class LoginStatus {
		private boolean isSuccess;
		private String message;

		public LoginStatus(boolean isSuccess, String message) {
			super();
			this.setSuccess(isSuccess);
			this.setMessage(message);
		}

		public boolean isSuccess() {
			return isSuccess;
		}

		public void setSuccess(boolean isSuccess) {
			this.isSuccess = isSuccess;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}
}
