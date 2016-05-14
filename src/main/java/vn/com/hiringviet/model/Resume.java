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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "RESUME", catalog = "hiringviet")
public class Resume implements Serializable {

	private static final long serialVersionUID = -4931216192214091278L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESUME_ID", nullable = false, length = 11)
	private Integer resumeID;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DISTRICT_ID", nullable = false)
	private District district;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "RESUME_SKILL", catalog = "hiringviet", joinColumns = { @JoinColumn(name = "RESUME_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "SKILL_ID", nullable = false, updatable = false) })
	private Set<Skill> skillSet;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "resume")
	private Set<EducationHistory> educationHistorySet;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "resume")
	private Set<EmploymentHistory> employeeHistorySet;

	@Column(name = "FULL_NAME", nullable = false, length = 100)
	private String fullName;

	@Column(name = "PHONE_NUMBER", length = 15)
	private String phoneNumber;

	@Column(name = "SEX")
	private boolean sex;

	@Column(name = "ADDRESS", length = 300)
	private String address;

	@Column(name = "NOTIONALITY", length = 300)
	private String notionality;

	@Column(name = "AVATAR_IMAGE")
	private byte[] avatarImage;

	@Column(name = "COVER_IMAGE")
	private byte[] coverImage;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	@Column(name = "CREATED_AT", nullable = false)
	private Date createdAt;

	@Column(name = "UPDATED_AT", nullable = false)
	private Date updatedAt;

	@Column(name = "DELETED_AT")
	private Date deletedAt;

	public Integer getResumeID() {
		return resumeID;
	}

	public void setResumeID(Integer resumeID) {
		this.resumeID = resumeID;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Set<Skill> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(Set<Skill> skillSet) {
		this.skillSet = skillSet;
	}

	public Set<EducationHistory> getEducationHistorySet() {
		return educationHistorySet;
	}

	public void setEducationHistorySet(Set<EducationHistory> educationHistorySet) {
		this.educationHistorySet = educationHistorySet;
	}

	public Set<EmploymentHistory> getEmployeeHistorySet() {
		return employeeHistorySet;
	}

	public void setEmployeeHistorySet(Set<EmploymentHistory> employeeHistorySet) {
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
