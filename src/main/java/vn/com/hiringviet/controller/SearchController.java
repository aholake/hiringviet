package vn.com.hiringviet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.request.SearchRequestDTO;
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
	public String goSearch(Model model) {

		Account account = getLoggedAccount();

		List<Job> jobList = null;
		List<Company> companyList = null;

		if (Utils.isEmptyObject(account) || AccountRoleEnum.COMPANY == account.getUserRole()) {

			jobList = jobService.getJobList(null, 0, ConstantValues.MAX_RECORD_COUNT,
					true, null);
			companyList = companyService.getListCompany(0,
					ConstantValues.MAX_RECORD_COUNT, true);
		} else {

			Member member = memberService.getMemberByAccount(account);
			List<Integer> skillIds = resumeService.getListSkillByMemberId(member.getId());
			jobList = jobService.getJobList(null, 0, ConstantValues.MAX_RECORD_COUNT, false, skillIds);
			companyList = companyService.getListCompany(0, ConstantValues.MAX_RECORD_COUNT, false);
			model.addAttribute("account", account);
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
	public @ResponseBody SearchSuggestResponseDTO getSuggest(@RequestBody SearchRequestDTO searchRequestDTO, HttpSession session) {

		searchRequestDTO.setKeyWord(searchRequestDTO.getKeyWord().replace("\"", ""));
		SearchSuggestResponseDTO response = new SearchSuggestResponseDTO();

		List<MemberDTO> memberResponseDTOs = null;
		if (searchRequestDTO.isSearchMember()) {
			memberResponseDTOs = memberService.getListMemberSuggest(searchRequestDTO.getKeyWord());
		}

		List<CompanyDTO> companyResponseDTOs = null;
		if (searchRequestDTO.isSearchCompany()) {
			companyResponseDTOs = companyService.getListCompanySuggest(searchRequestDTO.getKeyWord());
		}

		List<SkillDTO> skills = null;
		if (searchRequestDTO.isSearchSkill()) {
			skills = skillService.searchSkillByKeyWord(searchRequestDTO.getKeyWord());
		}

		List<JobSuggestDTO> jobSuggestDTOs = null;
		if (searchRequestDTO.isSearchJob()) {
			jobSuggestDTOs = new ArrayList<JobSuggestDTO>();
		}

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

	private Account getLoggedAccount() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof Account) {
			Account loginedAccount = (Account) principal;
			return loginedAccount;
		}
		return null;
	}
}
