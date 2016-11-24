package vn.com.hiringviet.dto;

import java.io.Serializable;

public class ApplyDTO implements Serializable {

	private static final long serialVersionUID = 3351635070229440700L;

	private String jobList;

	public String getJobList() {
		return jobList;
	}

	public void setJobList(String jobList) {
		this.jobList = jobList;
	}

}
