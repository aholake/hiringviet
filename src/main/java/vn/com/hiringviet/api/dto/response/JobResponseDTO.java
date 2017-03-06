package vn.com.hiringviet.api.dto.response;

import java.util.List;
import java.util.Map;

import vn.com.hiringviet.model.Job;

// TODO: Auto-generated Javadoc
/**
 * The Class JobResponseDTO.
 */
public class JobResponseDTO extends CommonResponseDTO {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1793760903887832216L;

	/** The job list. */
	private List<Job> jobList;

	/** The apply numbers. */
	private Map<Integer, Long> applyNumbers;

	/**
	 * Gets the job list.
	 *
	 * @return the job list
	 */
	public List<Job> getJobList() {
		return jobList;
	}

	/**
	 * Sets the job dto list.
	 *
	 * @param jobList the new job dto list
	 */
	public void setJobDTOList(List<Job> jobList) {
		this.jobList = jobList;
	}

	/**
	 * Gets the apply numbers.
	 *
	 * @return the apply numbers
	 */
	public Map<Integer, Long> getApplyNumbers() {
		return applyNumbers;
	}

	/**
	 * Sets the apply numbers.
	 *
	 * @param applyNumbers the apply numbers
	 */
	public void setApplyNumbers(Map<Integer, Long> applyNumbers) {
		this.applyNumbers = applyNumbers;
	}

}
