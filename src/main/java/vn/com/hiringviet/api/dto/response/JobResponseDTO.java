package vn.com.hiringviet.api.dto.response;

import java.util.List;
import java.util.Map;

import vn.com.hiringviet.model.Job;

public class JobResponseDTO extends CommonResponseDTO {

	private static final long serialVersionUID = -1793760903887832216L;

	private List<Job> jobList;

	private Map<Integer, Long> applyNumbers;

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobDTOList(List<Job> jobList) {
		this.jobList = jobList;
	}

	public Map<Integer, Long> getApplyNumbers() {
		return applyNumbers;
	}

	public void setApplyNumbers(Map<Integer, Long> applyNumbers) {
		this.applyNumbers = applyNumbers;
	}

}
