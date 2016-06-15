package vn.com.hiringviet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.hiringviet.service.MemberService;

@Controller
public class NavbarController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/layouts/navbar")
	public String navbar(HttpServletRequest request, HttpSession session) {
//		Cookie[] cookies = request.getCookies();
//		if (cookies != null) {
//			String email = null, password = null;
//			for (Cookie cookie : cookies) {
//				if (cookie.getName().equals("email")) {
//					email = cookie.getValue();
//				}
//				if (cookie.getName().equals("password")) {
//					password = cookie.getValue();
//				}
//			}
//			Member member = loginByCookie(email, password);
//
//			if (member != null) {
//				session.setAttribute("member", member);
//			}
//		}

		return "layouts/navbar";
	}
//
//	private Member loginByCookie(String username, String password) {
//		Member member = memberService.checkLogin(username, password);
//		if (member != null) {
//			return member;
//		}
//		return null;
//	}
}
