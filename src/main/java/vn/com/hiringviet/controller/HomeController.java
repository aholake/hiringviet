
package vn.com.hiringviet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.hiringviet.common.AccountRoleEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dto.LoggerDTO;
import vn.com.hiringviet.dto.SearchDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Country;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.CountryService;
import vn.com.hiringviet.service.JobService;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.service.ResumeService;
import vn.com.hiringviet.service.SkillService;
import vn.com.hiringviet.util.Utils;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeController.
 */
@Controller
public class HomeController {

	/** The job service. */
	@Autowired
	private JobService jobService;

	/** The company service. */
	@Autowired
	private CompanyService companyService;

	/** The member service. */
	@Autowired
	private MemberService memberService;

	/** The skill service. */
	@Autowired
	private SkillService skillService;

	/** The resume service. */
	@Autowired
	private ResumeService resumeService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private AccountService accountService;

	/**
	 * Go home page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return home page
	 */
	@RequestMapping(value = { "/", "home"})
	public String goHomePage(Model model, 
			@RequestParam(value = "mode", required = false) String mode, 
			@RequestParam(value = "keyValue", required = false) String keyValue) {

		String result = null;
		Account account = getLoggedAccount();

		List<Job> jobList = null;
		List<Company> companyList = null;
		List<Integer> skillIds = null;
		if (Utils.isEmptyObject(account) || AccountRoleEnum.COMPANY == account.getUserRole()) {

			jobList = jobService.getJobList(null, ConstantValues.FIRST_RECORD, ConstantValues.MAX_RECORD_COUNT, true, skillIds, mode, keyValue);
			companyList = companyService.getListCompany(ConstantValues.FIRST_RECORD, ConstantValues.MAX_RECORD_COUNT, true);
			result = "home";
		} else {
			
			Member member = account.getMember();
			skillIds = resumeService.getListSkillByMemberId(member.getId());
			jobList = jobService.getJobList(null, ConstantValues.FIRST_RECORD, ConstantValues.MAX_RECORD_COUNT, false, skillIds, mode, keyValue);
			companyList = companyService.getListCompany(ConstantValues.FIRST_RECORD, ConstantValues.MAX_RECORD_COUNT, false);
			
			model.addAttribute("account", account);
			
			Map<Integer, Apply> applyMap = setApplyMap(member.getApplySet());
			model.addAttribute("applyMap", applyMap);

			List<LoggerDTO> loggers = accountService.getListLogger(account.getId());
			if (loggers != null) {
				model.addAttribute("loggers", loggers);
			}

			result = "home_login";
		}

		List<Country> countries = countryService.getCountryList();
		model.addAttribute("countries", countries);

		model.addAttribute("firstItem", 0);
		model.addAttribute("maxItem", ConstantValues.MAX_RECORD_COUNT);
		model.addAttribute("currentPage", ConstantValues.CURRENT_PAGE);
		if (ConstantValues.MAX_RECORD_COUNT > jobList.size()) {
			model.addAttribute("isDisabledLoadJob", true);
		}
		model.addAttribute("jobList", jobList);
		model.addAttribute("companyList", companyList);

		return result;
	}

	@RequestMapping(value = { "/", "home"}, params = "search")
	public String search(Model model,
			@ModelAttribute SearchDTO searchDTO) {

		List<Job> jobList = jobService.searchJob(ConstantValues.FIRST_RECORD, ConstantValues.MAX_RECORD_COUNT, searchDTO);
		List<Company> companyList = companyService.getListCompany(ConstantValues.FIRST_RECORD, ConstantValues.MAX_RECORD_COUNT, true);

		if (ConstantValues.MAX_RECORD_COUNT > jobList.size()) {
			model.addAttribute("isDisabledLoadJob", true);
		}
		List<Country> countries = countryService.getCountryList();
		model.addAttribute("countries", countries);
		model.addAttribute("firstItem", 0);
		model.addAttribute("maxItem", ConstantValues.MAX_RECORD_COUNT);
		model.addAttribute("currentPage", ConstantValues.CURRENT_PAGE);
		model.addAttribute("jobList", jobList);
		model.addAttribute("companyList", companyList);

		return "home";
	}

	private Map<Integer, Apply> setApplyMap(Set<Apply> applyList) {
		Map<Integer, Apply> result = new HashMap<>();
		for (Apply apply : applyList) {
			result.put(apply.getApplyID(), apply);
		}
		return result;
	}
	
	private Account getLoggedAccount() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof Account) {
			Account loginedAccount = (Account) principal;
			return loginedAccount;
		}
		return null;
	}

	@RequestMapping(value = {"error/500"})
	public String goErrorPage(Model model) {
		return "500";
	}
}
