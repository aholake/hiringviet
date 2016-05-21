package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JobDTO implements Serializable {

	private static final long serialVersionUID = -3278815174799070361L;

	private Integer jobID;
	
	@JsonIgnore
	private JobCategoryDTO jobCategory;

	@JsonIgnore
	private CompanyDTO company;

	@JsonIgnore
	private DistrictDTO district;

	@JsonIgnore
	private Set<SkillDTO> skillSet;

	@JsonIgnore
	private Set<CommentDTO> commentSet;

	@JsonIgnore
	private Set<ApplyDTO> applySet;

	private String title;

	private String description;

	private Double minSalary;

	private Double maxSalary;

	private Date postDate;

	private String requirement;

	@JsonIgnore
	private PositionDTO position;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	public Integer getJobID() {
		return jobID;
	}

	public void setJobID(Integer jobID) {
		this.jobID = jobID;
	}

	public JobCategoryDTO getJobCategory() {
		return jobCategory;
	}

	public void setJobCategory(JobCategoryDTO jobCategory) {
		this.jobCategory = jobCategory;
	}

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	public DistrictDTO getDistrict() {
		return district;
	}

	public void setDistrict(DistrictDTO district) {
		this.district = district;
	}

	public Set<SkillDTO> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(Set<SkillDTO> skillSet) {
		this.skillSet = skillSet;
	}

	public Set<CommentDTO> getCommentSet() {
		return commentSet;
	}

	public void setCommentSet(Set<CommentDTO> commentSet) {
		this.commentSet = commentSet;
	}

	public Set<ApplyDTO> getApplySet() {
		return applySet;
	}

	public void setApplySet(Set<ApplyDTO> applySet) {
		this.applySet = applySet;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
		
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public PositionDTO getPosition() {
		return position;
	}

	public void setPosition(PositionDTO position) {
		this.position = position;
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

}
