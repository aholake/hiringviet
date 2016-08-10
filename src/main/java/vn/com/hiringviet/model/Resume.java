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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "resume")
public class Resume implements Serializable {

	private static final long serialVersionUID = -4931216192214091278L;

	private Integer id;

	private Member member;

	private Set<EducationHistory> educationHistorySet;

	private Set<EmploymentHistory> employeeHistorySet;

	private String phoneNumber;

	private Address address;

	private boolean maleGender;

	private String nationality;

	private String avatarImage;

	private String coverImage;

	private Date birthDate;

	private String summary;

	private ChangeLog changeLog;

	private Set<SkillResume> skillResumeSet;

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

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@OrderBy("beginYear ASC")
	public Set<EducationHistory> getEducationHistorySet() {
		return educationHistorySet;
	}

	public void setEducationHistorySet(Set<EducationHistory> educationHistorySet) {
		this.educationHistorySet = educationHistorySet;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@OrderBy("beginDate ASC")
	public Set<EmploymentHistory> getEmployeeHistorySet() {
		return employeeHistorySet;
	}

	public void setEmployeeHistorySet(Set<EmploymentHistory> employeeHistorySet) {
		this.employeeHistorySet = employeeHistorySet;
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
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
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

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "summary")
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "change_log_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public ChangeLog getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@OrderBy("endorseSet DESC")
	public Set<SkillResume> getSkillResumeSet() {
		return skillResumeSet;
	}

	public void setSkillResumeSet(Set<SkillResume> skillResumeSet) {
		this.skillResumeSet = skillResumeSet;
	}

}
