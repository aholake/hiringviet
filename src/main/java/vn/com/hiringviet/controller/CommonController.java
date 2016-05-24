package vn.com.hiringviet.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.service.CountryService;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.util.ResourceNotFoundException;
import vn.com.hiringviet.util.Utils;

@Controller
public class CommonController {
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = { "/", "/home" })
	public String home(Model model, HttpSession session) {
		MemberDTO memberDTO = Utils.getMemberSession(session);

		if (!Utils.isEmptyObject(memberDTO)) {
			return "home_login";
		}
		return "home";
	}

	@RequestMapping("/login")
	public String loginPage(HttpSession session) {
		if (Utils.getMemberSession(session) != null) {
			throw new ResourceNotFoundException();
		}
		return "login_page";
	}

	@RequestMapping(value = "/layouts/navbar")
	public String navbar(HttpServletRequest request, HttpSession session) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			String email = null, password = null;
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("email")) {
					email = cookie.getValue();
				}
				if(cookie.getName().equals("password")) {
					password = cookie.getValue();
				}
			}
			MemberDTO memberDTO = loginByCookie(email, password);
			
			if(memberDTO != null) {
				session.setAttribute("memberDTO", memberDTO);
			}
		}
		
		return "layouts/navbar";
	}

	@RequestMapping(value = "/layouts/footer")
	public String footer() {
		return "layouts/footer";
	}
	
	private MemberDTO loginByCookie(String username, String password) {
		MemberDTO memberDTO = memberService.checkLogin(username, password);
		if(memberDTO != null) {
			return memberDTO;
		}
		return null;
	}
}
