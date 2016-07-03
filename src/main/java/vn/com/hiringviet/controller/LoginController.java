package vn.com.hiringviet.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.response.AccountDTO;
import vn.com.hiringviet.api.dto.response.CommonResponseDTO;
import vn.com.hiringviet.common.MemberRoleEnum;
import vn.com.hiringviet.common.StatusResponseEnum;
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

	@RequestMapping(value = "/account/checkAccount", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO login(
			@RequestBody AccountDTO accountDTO, HttpServletResponse response,
			HttpSession session) {

		CommonResponseDTO commonResponseDTO = new CommonResponseDTO();
		Account account = accountService.checkLogin(accountDTO.getEmail(), accountDTO.getPassword());

		if (account == null) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return commonResponseDTO;
		}

		if (accountDTO.isRemembered()) {
			CookieUtil.createCookie(response, "email", account.getEmail());
			CookieUtil.createCookie(response, "password", account.getPassword());
		}

		session.setAttribute("account", account);

		if (MemberRoleEnum.USER.getValue() == account.getRoleID()) {
			session.setAttribute("memberSession", memberService.getMemberByAccount(account));
		} else if (MemberRoleEnum.COMPANY.getValue() == account.getRoleID()) {
			session.setAttribute("companySession", companyService.getCompanyByAccount(account));
		} else {
			
		}

		commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return commonResponseDTO;
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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "login_page";
	}
}
