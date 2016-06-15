package vn.com.hiringviet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
	public String goCompanyPage(@PathVariable("id") Integer id, Model model, HttpSession session) {

		Company company = companyService.findOne(id);

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

	@RequestMapping(value = "/company/careers/{id}", method = RequestMethod.GET)
	public String goJobDetailPage(Model model, HttpSession session) {

		return "job-detail";
	}
}
