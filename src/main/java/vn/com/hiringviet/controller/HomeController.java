package vn.com.hiringviet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.JobService;
import vn.com.hiringviet.util.Utils;

@Controller
public class HomeController {

	@Autowired
	private JobService jobService;

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = {"/", "home"})
	public String goHomePage(Model model, HttpSession session) {

		String result = null;
		Account account = LoginController.getAccountSession(session);

		List<Job> jobList = null;
		List<Company> companyList = null;

		if (Utils.isEmptyObject(account)) {
			jobList = jobService.getJobList(0, 10, true);
			companyList = companyService.getListCompany(0, 10, true);
			result = "home";
		} else {
			jobList = jobService.getJobList(0, 10, false);
			companyList = companyService.getListCompany(0, 10, false);
			result = "home_login";
		}

		model.addAttribute("jobList", jobList);
		model.addAttribute("companyList", companyList);

		return result;
	}
}
