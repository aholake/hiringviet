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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SKILL", catalog = "hiringviet")
public class Skill implements Serializable {

	private static final long serialVersionUID = -5381027238277880906L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SKILL_ID", nullable = false, length = 11)
	private Integer skillID;

	@Column(name = "DISPLAY_NAME", nullable = false, length = 200)
	private String displayName;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	@Column(name = "DELETED_AT", nullable = true)
	private Date deletedAt;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "skillSet")
	private Set<Resume> resumeSet;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "skillSet")
	private Set<Job> jobSet;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "skill")
	private Set<Endorse> endorseSet;

	public Integer getSkillID() {
		return skillID;
	}

	public void setSkillID(Integer skillID) {
		this.skillID = skillID;
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

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Set<Resume> getResumeSet() {
		return resumeSet;
	}

	public void setResumeSet(Set<Resume> resumeSet) {
		this.resumeSet = resumeSet;
	}

	public Set<Job> getJobSet() {
		return jobSet;
	}

	public void setJobSet(Set<Job> jobSet) {
		this.jobSet = jobSet;
	}

	public Set<Endorse> getEndorseSet() {
		return endorseSet;
	}

	public void setEndorseSet(Set<Endorse> endorseSet) {
		this.endorseSet = endorseSet;
	}

}
