package vn.com.hiringviet.dto;

import java.io.Serializable;

public class ApplyDTO implements Serializable {

	private static final long serialVersionUID = 3351635070229440700L;

	private String jobList; 

	private String curriculumVitae;

	private String description;

	public String getJobList() {
		return jobList;
	}

	public void setJobList(String jobList) {
		this.jobList = jobList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurriculumVitae() {
		return curriculumVitae;
	}

	public void setCurriculumVitae(String curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

	

}
