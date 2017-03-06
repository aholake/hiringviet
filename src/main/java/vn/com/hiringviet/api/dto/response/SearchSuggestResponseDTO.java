package vn.com.hiringviet.api.dto.response;

import java.util.List;

import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.SkillDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchSuggestResponseDTO.
 */
public class SearchSuggestResponseDTO extends CommonResponseDTO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5063631610545973463L;

	/** The job dt os. */
	private List<JobDTO> jobDTOs;

	/** The company response dt os. */
	private List<CompanyDTO> companyResponseDTOs;

	/** The member response dt os. */
	private List<MemberDTO> memberResponseDTOs;

	/** The skill dt os. */
	private List<SkillDTO> skillDTOs;

	/**
	 * Gets the job dt os.
	 *
	 * @return the job dt os
	 */
	public List<JobDTO> getJobDTOs() {
		return jobDTOs;
	}

	/**
	 * Sets the job dt os.
	 *
	 * @param jobDTOs the new job dt os
	 */
	public void setJobDTOs(List<JobDTO> jobDTOs) {
		this.jobDTOs = jobDTOs;
	}

	/**
	 * Gets the company response dt os.
	 *
	 * @return the company response dt os
	 */
	public List<CompanyDTO> getCompanyResponseDTOs() {
		return companyResponseDTOs;
	}

	/**
	 * Sets the company response dt os.
	 *
	 * @param companyResponseDTOs the new company response dt os
	 */
	public void setCompanyResponseDTOs(List<CompanyDTO> companyResponseDTOs) {
		this.companyResponseDTOs = companyResponseDTOs;
	}

	/**
	 * Gets the member response dt os.
	 *
	 * @return the member response dt os
	 */
	public List<MemberDTO> getMemberResponseDTOs() {
		return memberResponseDTOs;
	}

	/**
	 * Sets the member response dt os.
	 *
	 * @param memberResponseDTOs the new member response dt os
	 */
	public void setMemberResponseDTOs(List<MemberDTO> memberResponseDTOs) {
		this.memberResponseDTOs = memberResponseDTOs;
	}

	/**
	 * Gets the skill dt os.
	 *
	 * @return the skill dt os
	 */
	public List<SkillDTO> getSkillDTOs() {
		return skillDTOs;
	}

	/**
	 * Sets the skill dt os.
	 *
	 * @param skillDTOs the new skill dt os
	 */
	public void setSkillDTOs(List<SkillDTO> skillDTOs) {
		this.skillDTOs = skillDTOs;
	}

}
