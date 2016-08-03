package vn.com.hiringviet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping(value = "/admin")
	public String goHomePage(Model model, HttpSession session) {
		return "/admin/home";
	}
}
