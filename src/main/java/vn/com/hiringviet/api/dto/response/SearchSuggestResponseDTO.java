package vn.com.hiringviet.api.dto.response;

import java.util.List;

import vn.com.hiringviet.model.Skill;

public class SearchSuggestResponseDTO extends CommonResponseDTO {

	private static final long serialVersionUID = 5063631610545973463L;

	private List<JobSuggestDTO> jobSuggestDTOs;

	private List<CompanyResponseDTO> companyResponseDTOs;

	private List<MemberResponseDTO> memberResponseDTOs;

	private List<Skill> skills;

	public List<JobSuggestDTO> getJobSuggestDTOs() {
		return jobSuggestDTOs;
	}

	public void setJobSuggestDTOs(List<JobSuggestDTO> jobSuggestDTOs) {
		this.jobSuggestDTOs = jobSuggestDTOs;
	}

	public List<CompanyResponseDTO> getCompanyResponseDTOs() {
		return companyResponseDTOs;
	}

	public void setCompanyResponseDTOs(
			List<CompanyResponseDTO> companyResponseDTOs) {
		this.companyResponseDTOs = companyResponseDTOs;
	}

	public List<MemberResponseDTO> getMemberResponseDTOs() {
		return memberResponseDTOs;
	}

	public void setMemberResponseDTOs(List<MemberResponseDTO> memberResponseDTOs) {
		this.memberResponseDTOs = memberResponseDTOs;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

}
