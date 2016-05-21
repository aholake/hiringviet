package vn.com.hiringviet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.model.Country;
import vn.com.hiringviet.service.CountryService;
import vn.com.hiringviet.util.Utils;

@Controller
public class CommonController {
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value = {"/","/home"})
	public String home(Model model, HttpSession session) {
		MemberDTO memberDTO = Utils.getMemberSession(session);

		if (!Utils.isEmptyObject(memberDTO)) {
			String locale = memberDTO.getLocale();
			return "redirect:home_login?locale=" + locale;
		}
		return "home";
	}
	
	@RequestMapping(value = "/homeLogin")
	public String homeLogin() {
		return "home_login";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login_page";
	}
	
	@RequestMapping(value = "/layouts/navbar")
	public String navbar() {
		return "layouts/navbar";
	}
	
	@RequestMapping(value = "/layouts/footer")
	public String footer() {
		return "layouts/footer";
	}
	
	@RequestMapping(value = "/testCommon")
	public @ResponseBody Country getCountries() {
		Country country = countryService.getCountryById(1);
		System.out.println(country);
		return country;
	}
}
