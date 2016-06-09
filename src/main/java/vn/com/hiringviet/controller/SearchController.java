package vn.com.hiringviet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.response.CompanyResponseDTO;
import vn.com.hiringviet.api.dto.response.JobSuggestDTO;
import vn.com.hiringviet.api.dto.response.MemberResponseDTO;
import vn.com.hiringviet.api.dto.response.SearchSuggestResponseDTO;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.model.Skill;

@Controller
public class SearchController {

	@RequestMapping(value = "/search/suggest", method = RequestMethod.POST)
	public @ResponseBody SearchSuggestResponseDTO getSuggest(Model model, HttpSession session) {

		SearchSuggestResponseDTO response = new SearchSuggestResponseDTO();

		MemberResponseDTO member = new MemberResponseDTO();
		member.setId(1);
		member.setFirstName("Nguyen");
		member.setLastName("Tuan Anh");
		List<MemberResponseDTO> memberResponseDTOs = new ArrayList<MemberResponseDTO>();
		memberResponseDTOs.add(member);
		memberResponseDTOs.add(member);
		memberResponseDTOs.add(member);

		CompanyResponseDTO company = new CompanyResponseDTO();
		company.setId(1);
		company.setDisplayName("Tan Hiep Phat");
		company.setCompanySize(100);
		List<CompanyResponseDTO> companyResponseDTOs = new ArrayList<CompanyResponseDTO>();
		companyResponseDTOs.add(company);
		companyResponseDTOs.add(company);

		Skill skill = new Skill();
		skill.setDisplayName("Java");
		List<Skill> skills = new ArrayList<Skill>();
		skills.add(skill);
		skills.add(skill);

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
}
