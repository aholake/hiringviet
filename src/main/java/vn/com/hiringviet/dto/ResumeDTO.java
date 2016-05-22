package vn.com.hiringviet.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ResumeDTO implements Serializable {

	private static final long serialVersionUID = -4931216192214091278L;

	private Integer resumeID;

	private MemberDTO member;

	private DistrictDTO district;

	@JsonIgnore
	private List<SkillDTO> skillSet;

	@JsonIgnore
	private List<EducationHistoryDTO> educationHistorySet;

	@JsonIgnore
	private List<EmploymentHistoryDTO> employeeHistorySet;

	private String fullName;

	private String phoneNumber;

	private boolean sex;

	private String address;

	private String notionality;

	private byte[] avatarImage;

	private byte[] coverImage;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;

	private Date deletedAt;

	public Integer getResumeID() {
		return resumeID;
	}

	public void setResumeID(Integer resumeID) {
		this.resumeID = resumeID;
	}

	public MemberDTO getMember() {
		return member;
	}

	public void setMember(MemberDTO member) {
		this.member = member;
	}

	public DistrictDTO getDistrict() {
		return district;
	}

	public void setDistrict(DistrictDTO district) {
		this.district = district;
	}

	public List<SkillDTO> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(List<SkillDTO> skillSet) {
		this.skillSet = skillSet;
	}

	public List<EducationHistoryDTO> getEducationHistorySet() {
		return educationHistorySet;
	}

	public void setEducationHistorySet(List<EducationHistoryDTO> educationHistorySet) {
		this.educationHistorySet = educationHistorySet;
	}

	public List<EmploymentHistoryDTO> getEmployeeHistorySet() {
		return employeeHistorySet;
	}

	public void setEmployeeHistorySet(List<EmploymentHistoryDTO> employeeHistorySet) {
		this.employeeHistorySet = employeeHistorySet;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNotionality() {
		return notionality;
	}

	public void setNotionality(String notionality) {
		this.notionality = notionality;
	}

	public byte[] getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(byte[] avatarImage) {
		this.avatarImage = avatarImage;
	}

	public byte[] getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(byte[] coverImage) {
		this.coverImage = coverImage;
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
