package vn.com.hiringviet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Posts;
import vn.com.hiringviet.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/company/{companyId}", method = RequestMethod.GET)
	public String goCompanyPage(@PathVariable("companyId") Integer companyId, Model model, HttpSession session) {

		Company company = companyService.findOne(companyId);
		List<Posts> postsList = companyService.getListPosts(0, ConstantValues.MAX_RECORD_COUNT, companyId);

		if (ConstantValues.MAX_RECORD_COUNT > postsList.size()) {
			model.addAttribute("isDisabledLoadPosts", true);
		}
		model.addAttribute("postsList", postsList);
		model.addAttribute("company", company);
		return "company";
	}

	@RequestMapping(value = "/company/{companyId}/job", method = RequestMethod.GET)
	public String goCompanyCarrersPage(@PathVariable("companyId") Integer companyId, Model model, HttpSession session) {

		Company company = companyService.findOne(companyId);
		List<Job> jobList = companyService.getListJob(0, ConstantValues.MAX_RECORD_COUNT, companyId);

		if (ConstantValues.MAX_RECORD_COUNT > jobList.size()) {
			model.addAttribute("isDisabledLoadJob", true);
		}

		model.addAttribute("jobList", jobList);
		model.addAttribute("company", company);
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
