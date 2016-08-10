package vn.com.hiringviet.api.dto.response;

import java.util.List;

import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.SkillDTO;

public class SearchSuggestResponseDTO extends CommonResponseDTO {

	private static final long serialVersionUID = 5063631610545973463L;

	private List<JobSuggestDTO> jobSuggestDTOs;

	private List<CompanyDTO> companyResponseDTOs;

	private List<MemberDTO> memberResponseDTOs;

	private List<SkillDTO> skills;

	public List<JobSuggestDTO> getJobSuggestDTOs() {
		return jobSuggestDTOs;
	}

	public void setJobSuggestDTOs(List<JobSuggestDTO> jobSuggestDTOs) {
		this.jobSuggestDTOs = jobSuggestDTOs;
	}

	public List<CompanyDTO> getCompanyResponseDTOs() {
		return companyResponseDTOs;
	}

	public void setCompanyResponseDTOs(List<CompanyDTO> companyResponseDTOs) {
		this.companyResponseDTOs = companyResponseDTOs;
	}

	public List<MemberDTO> getMemberResponseDTOs() {
		return memberResponseDTOs;
	}

	public void setMemberResponseDTOs(List<MemberDTO> memberResponseDTOs) {
		this.memberResponseDTOs = memberResponseDTOs;
	}

	public List<SkillDTO> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillDTO> skills) {
		this.skills = skills;
	}

}
