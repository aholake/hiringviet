package vn.com.hiringviet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.response.JobSuggestDTO;
import vn.com.hiringviet.api.dto.response.SearchSuggestResponseDTO;
import vn.com.hiringviet.common.AccountRoleEnum;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Country;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.CountryService;
import vn.com.hiringviet.service.JobService;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.service.ResumeService;
import vn.com.hiringviet.service.SkillService;
import vn.com.hiringviet.util.Utils;

@Controller
public class SearchController {

	@Autowired
	private SkillService skillService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private CompanyService companyService;

	/** The job service. */
	@Autowired
	private JobService jobService;

	/** The resume service. */
	@Autowired
	private ResumeService resumeService;

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String goSearch(Model model, HttpSession session) {
		String result = null;
		Account account = LoginController.getAccountSession(session);

		List<Job> jobList = null;
		List<Company> companyList = null;

		if (Utils.isEmptyObject(account) || AccountRoleEnum.COMPANY == account.getUserRole()) {

			jobList = jobService.getJobList(null, 0, ConstantValues.MAX_RECORD_COUNT,
					true, null);
			companyList = companyService.getListCompany(0,
					ConstantValues.MAX_RECORD_COUNT, true);
			result = "home";
		} else {

			Member member = memberService.getMemberByAccount(account);
			List<Integer> skillIds = resumeService.getListSkillByMemberId(member.getId());
			jobList = jobService.getJobList(null, 0, ConstantValues.MAX_RECORD_COUNT, false, skillIds);
			companyList = companyService.getListCompany(0, ConstantValues.MAX_RECORD_COUNT, false);
			model.addAttribute("account", account);
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
		return "/search";
	}

	@RequestMapping(value = "/search/suggest", method = RequestMethod.POST)
	public @ResponseBody SearchSuggestResponseDTO getSuggest(@RequestBody String keywork, HttpSession session) {

		System.out.println(keywork);
		keywork = keywork.replace("\"", "");
		SearchSuggestResponseDTO response = new SearchSuggestResponseDTO();

		List<MemberDTO> memberResponseDTOs = memberService.getListMemberSuggest(keywork);

		List<CompanyDTO> companyResponseDTOs = companyService.getListCompanySuggest(keywork);

		List<SkillDTO> skills = skillService.searchSkillByKeyWord(keywork);

//		JobSuggestDTO job = new JobSuggestDTO();
//		job.setDisplayName("Cong Viec A");
		List<JobSuggestDTO> jobSuggestDTOs = new ArrayList<JobSuggestDTO>();
//		jobSuggestDTOs.add(job);

		response.setResult(StatusResponseEnum.SUCCESS.getStatus());
		response.setCompanyResponseDTOs(companyResponseDTOs);
		response.setMemberResponseDTOs(memberResponseDTOs);
		response.setJobSuggestDTOs(jobSuggestDTOs);
		response.setSkills(skills);
		return response;
	}

	@RequestMapping(value = "/search/suggestSkill", method = RequestMethod.POST)
	public @ResponseBody List<SkillDTO> suggestSkill(@RequestBody String keyWord, HttpSession session) {

		return skillService.searchSkillByKeyWord(keyWord);
	}
}
