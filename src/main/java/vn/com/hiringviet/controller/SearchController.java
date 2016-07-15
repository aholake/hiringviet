package vn.com.hiringviet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.response.JobSuggestDTO;
import vn.com.hiringviet.api.dto.response.SearchSuggestResponseDTO;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.service.SkillService;

@Controller
public class SearchController {

	@Autowired
	private SkillService skillService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/search/suggest", method = RequestMethod.POST)
	public @ResponseBody SearchSuggestResponseDTO getSuggest(@RequestBody String keywork, HttpSession session) {

		keywork = keywork.replace("\"", "");
		SearchSuggestResponseDTO response = new SearchSuggestResponseDTO();

		List<MemberDTO> memberResponseDTOs = memberService.getListMemberSuggest(keywork);

		List<CompanyDTO> companyResponseDTOs = companyService.getListCompanySuggest(keywork);

		List<SkillDTO> skills = skillService.searchSkillByKeyWord(keywork);

		JobSuggestDTO job = new JobSuggestDTO();
		job.setDisplayName("Cong Viec A");
		List<JobSuggestDTO> jobSuggestDTOs = new ArrayList<JobSuggestDTO>();
		jobSuggestDTOs.add(job);

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
