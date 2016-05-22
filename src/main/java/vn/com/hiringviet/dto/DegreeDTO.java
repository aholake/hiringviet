package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class DegreeDTO implements Serializable {

	private static final long serialVersionUID = 3205589962671010114L;

	private Integer degreeID;

	private String displayName;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	@JsonIgnore
	private Set<EducationHistoryDTO> educationHistorySet;

	public Integer getDegreeID() {
		return degreeID;
	}

	public void setDegreeID(Integer degreeID) {
		this.degreeID = degreeID;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<EducationHistoryDTO> getEducationHistorySet() {
		return educationHistorySet;
	}

	public void setEducationHistorySet(Set<EducationHistoryDTO> educationHistorySet) {
		this.educationHistorySet = educationHistorySet;
	}

}
