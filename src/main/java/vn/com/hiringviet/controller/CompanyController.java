package vn.com.hiringviet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {

	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String goCompanyPage(Model model, HttpSession session) {

		return "company";
	}

	@RequestMapping(value = "/company/careers", method = RequestMethod.GET)
	public String goCompanyCarrersPage(Model model, HttpSession session) {

		return "company-careers";
	}

	@RequestMapping(value = "/layouts/companyBanner", method = RequestMethod.GET)
	public String goCompanyBanner(Model model, HttpSession session) {

		return "/layouts/company_banner";
	}

	@RequestMapping(value = "/layouts/companyHeader", method = RequestMethod.GET)
	public String goCompanyHeader(Model model, HttpSession session) {

		return "/layouts/company_header";
	}
}
