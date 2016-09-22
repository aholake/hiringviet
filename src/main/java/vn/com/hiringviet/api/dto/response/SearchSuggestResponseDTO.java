package vn.com.hiringviet.api.dto.response;

import java.util.List;

import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.SkillDTO;

public class SearchSuggestResponseDTO extends CommonResponseDTO {

	private static final long serialVersionUID = 5063631610545973463L;

	private List<JobDTO> jobDTOs;

	private List<CompanyDTO> companyResponseDTOs;

	private List<MemberDTO> memberResponseDTOs;

	private List<SkillDTO> skillDTOs;

	public List<JobDTO> getJobDTOs() {
		return jobDTOs;
	}

	public void setJobDTOs(List<JobDTO> jobDTOs) {
		this.jobDTOs = jobDTOs;
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

	public List<SkillDTO> getSkillDTOs() {
		return skillDTOs;
	}

	public void setSkillDTOs(List<SkillDTO> skillDTOs) {
		this.skillDTOs = skillDTOs;
	}

}
