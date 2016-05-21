package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "POSITION", catalog = "hiringviet")
public class Position implements Serializable {

	private static final long serialVersionUID = -45982404463146068L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POSITION_ID", nullable = false, length = 11)
	private Integer positionID;

	@Column(name = "DISPLAY_NAME", nullable = false, length = 200)
	private String displayName;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "position")
	private Set<EmploymentHistory> employmentHistorySet;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "position")
	private Set<Job> jobSet;

	public Integer getPositionID() {
		return positionID;
	}

	public void setPositionID(Integer positionID) {
		this.positionID = positionID;
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

	public Set<EmploymentHistory> getEmploymentHistorySet() {
		return employmentHistorySet;
	}

	public void setEmploymentHistorySet(
			Set<EmploymentHistory> employmentHistorySet) {
		this.employmentHistorySet = employmentHistorySet;
	}

	public Set<Job> getJobSet() {
		return jobSet;
	}

	public void setJobSet(Set<Job> jobSet) {
		this.jobSet = jobSet;
	}
}
