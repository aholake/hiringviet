//package vn.com.hiringviet.controller;
//
//
//import java.util.List;
//
//
//
//
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import vn.com.hiringviet.common.PagingEnum;
//import vn.com.hiringviet.model.Member;
//import vn.com.hiringviet.service.CountryService;
//import vn.com.hiringviet.service.JobService;
//import vn.com.hiringviet.util.Utils;
//
//@Controller
//public class CommonController {
//
//	@Autowired
//	private CountryService countryService;
//
//
//	@Autowired
//	private JobService jobService;
//
//	@RequestMapping(value = {"/","/home"})
//	public String home(Model model, HttpSession session) {
//
//		Member member = Utils.getMemberSession(session);
//
//		if (!Utils.isEmptyObject(member)) {
//			setModelAttribute(model, session);
//			return "home_login";
//		}
//		setModelAttribute(model, session);
//		return "home";
//	}
//
//
//	public void setModelAttribute(Model model, HttpSession session) {
//
//		List<Job> jobList = null;
//		Member member = Utils.getMemberSession(session);
//
//		if (!Utils.isEmptyObject(member)) {
//			jobList = jobService.getListJobHot(PagingEnum.FIRST.getValue(), PagingEnum.MAX.getValue());
//		}
//		jobList = jobService.getListJobHot(PagingEnum.FIRST.getValue(), PagingEnum.MAX.getValue());
//
//		model.addAttribute("jobList", jobList);
//	}
//
//
//	@RequestMapping("/login")
//	public String loginPage(HttpSession session) {
//		if (Utils.getMemberSession(session) != null) {
//			throw new ResourceNotFoundException();
//		}
//		return "login_page";
//	}
//
//	@RequestMapping(value = "/layouts/navbar")
//	public String navbar(HttpServletRequest request, HttpSession session) {
//		Cookie[] cookies = request.getCookies();
//		if(cookies != null) {
//			String email = null, password = null;
//			for (Cookie cookie : cookies) {
//				if(cookie.getName().equals("email")) {
//					email = cookie.getValue();
//				}
//				if(cookie.getName().equals("password")) {
//					password = cookie.getValue();
//				}
//			}
//			Member member = loginByCookie(email, password);
//			
//			if(member != null) {
//				session.setAttribute("member", member);
//			}
//		}
//		
//		return "layouts/navbar";
//	}
//
//	@RequestMapping(value = "/layouts/footer")
//	public String footer() {
//		return "layouts/footer";
//	}
//	
//	private Member loginByCookie(String username, String password) {
//		Member member = memberService.checkLogin(username, password);
//		if(member != null) {
//			return member;
//		}
//		return null;
//	}
//}