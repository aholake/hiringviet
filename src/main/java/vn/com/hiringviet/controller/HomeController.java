package vn.com.hiringviet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.JobService;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.util.Utils;

@Controller
public class HomeController {

	@Autowired
	private JobService jobService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private MemberService memberService;

	
	/**
	 * @param model
	 * @param session
	 * @return home page
	 */
	@RequestMapping(value = "home")
	public String goHomePage(Model model, HttpSession session) {

		String result = null;
		Account account = LoginController.getAccountSession(session);

		List<Job> jobList = null;
		List<Company> companyList = null;

		if (Utils.isEmptyObject(account)) {
			jobList = jobService.getJobList(0, ConstantValues.MAX_RECORD_COUNT, true, null);
			companyList = companyService.getListCompany(0, ConstantValues.MAX_RECORD_COUNT, true);
			result = "home";
		} else {
			jobList = jobService.getJobList(0, ConstantValues.MAX_RECORD_COUNT, false, null);
			companyList = companyService.getListCompany(0, ConstantValues.MAX_RECORD_COUNT, false);
			model.addAttribute("account", account);
			result = "home_login";
		}

		model.addAttribute("firstItem", 0);
		model.addAttribute("currentPage", ConstantValues.CURRENT_PAGE);
		model.addAttribute("jobList", jobList);
		model.addAttribute("companyList", companyList);

		return result;
	}
}
