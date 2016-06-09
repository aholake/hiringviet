package vn.com.hiringviet.api.dto.response;

import java.util.List;

import vn.com.hiringviet.model.Job;

public class JobResponseDTO extends CommonResponseDTO {

	private static final long serialVersionUID = -1793760903887832216L;

	private List<Job> jobList;

	public List<Job> getJobList() {
		return jobList;
	}

	public void setJobDTOList(List<Job> jobList) {
		this.jobList = jobList;
	}

}
