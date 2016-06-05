package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "resume")
public class Resume implements Serializable {

	private static final long serialVersionUID = -4931216192214091278L;

	private Integer id;

	private Member member;

	private List<Skill> skillList;

	private List<EducationHistory> educationHistoryList;

	private List<EmploymentHistory> employeeHistoryList;

	private String phoneNumber;

	private Address address;

	private boolean maleGender;

	private String nationality;

	private String avatarImage;

	private String coverImage;

	private ChangeLog changeLog;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer resumeID) {
		this.id = resumeID;
	}

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "resume_skill", joinColumns = { @JoinColumn(name = "resume_id") }, inverseJoinColumns = { @JoinColumn(name = "skill_id") })
	public List<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "resume")
	public List<EducationHistory> getEducationHistoryList() {
		return educationHistoryList;
	}

	public void setEducationHistoryList(
			List<EducationHistory> educationHistorySet) {
		this.educationHistoryList = educationHistorySet;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "resume")
	public List<EmploymentHistory> getEmployeeHistorySet() {
		return employeeHistoryList;
	}

	public void setEmployeeHistorySet(List<EmploymentHistory> employeeHistorySet) {
		this.employeeHistoryList = employeeHistorySet;
	}

	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "male_gender")
	public boolean isMaleGender() {
		return maleGender;
	}

	public void setMaleGender(boolean maleGender) {
		this.maleGender = maleGender;
	}

	@Column(name = "nationality")
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Column(name = "avatar_image")
	public String getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(String avatarImage) {
		this.avatarImage = avatarImage;
	}

	@Column(name = "cover_image")
	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "change_log_id")
	public ChangeLog getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

}
