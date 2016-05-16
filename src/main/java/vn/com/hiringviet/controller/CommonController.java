package vn.com.hiringviet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping(value = "/")
	public String home() {
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
}
