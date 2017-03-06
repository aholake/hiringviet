package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Resume.
 */
@Entity
@Table(name = "resume")
public class Resume implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4931216192214091278L;

	/** The id. */
	private Integer id;

	/** The member. */
	private Member member;

	/** The education history set. */
	private Set<EducationHistory> educationHistorySet = new HashSet<>();

	/** The employee history set. */
	private Set<EmploymentHistory> employeeHistorySet = new HashSet<>();

	/** The phone number. */
	private String phoneNumber;

	/** The address. */
	private Address address;

	/** The male gender. */
	private boolean maleGender;

	/** The nationality. */
	private String nationality;

	/** The avatar image. */
	private String avatarImage;

	/** The cover image. */
	private String coverImage;

	/** The birth date. */
	private Date birthDate;

	/** The summary. */
	private String summary;

	/** The change log. */
	private ChangeLog changeLog;

	/** The skill resume set. */
	private Set<SkillResume> skillResumeSet = new HashSet<>();

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param resumeID the new id
	 */
	public void setId(Integer resumeID) {
		this.id = resumeID;
	}

	/**
	 * Gets the member.
	 *
	 * @return the member
	 */
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	public Member getMember() {
		return member;
	}

	/**
	 * Sets the member.
	 *
	 * @param member the new member
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 * Gets the education history set.
	 *
	 * @return the education history set
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@OrderBy("beginYear ASC")
	public Set<EducationHistory> getEducationHistorySet() {
		return educationHistorySet;
	}

	/**
	 * Sets the education history set.
	 *
	 * @param educationHistorySet the new education history set
	 */
	public void setEducationHistorySet(Set<EducationHistory> educationHistorySet) {
		this.educationHistorySet = educationHistorySet;
	}

	/**
	 * Gets the employee history set.
	 *
	 * @return the employee history set
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@OrderBy("beginDate ASC")
	public Set<EmploymentHistory> getEmployeeHistorySet() {
		return employeeHistorySet;
	}

	/**
	 * Sets the employee history set.
	 *
	 * @param employeeHistorySet the new employee history set
	 */
	public void setEmployeeHistorySet(Set<EmploymentHistory> employeeHistorySet) {
		this.employeeHistorySet = employeeHistorySet;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Checks if is male gender.
	 *
	 * @return true, if is male gender
	 */
	@Column(name = "male_gender")
	public boolean isMaleGender() {
		return maleGender;
	}

	/**
	 * Sets the male gender.
	 *
	 * @param maleGender the new male gender
	 */
	public void setMaleGender(boolean maleGender) {
		this.maleGender = maleGender;
	}

	/**
	 * Gets the nationality.
	 *
	 * @return the nationality
	 */
	@Column(name = "nationality")
	public String getNationality() {
		return nationality;
	}

	/**
	 * Sets the nationality.
	 *
	 * @param nationality the new nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * Gets the avatar image.
	 *
	 * @return the avatar image
	 */
	@Column(name = "avatar_image")
	public String getAvatarImage() {
		return avatarImage;
	}

	/**
	 * Sets the avatar image.
	 *
	 * @param avatarImage the new avatar image
	 */
	public void setAvatarImage(String avatarImage) {
		this.avatarImage = avatarImage;
	}

	/**
	 * Gets the cover image.
	 *
	 * @return the cover image
	 */
	@Column(name = "cover_image")
	public String getCoverImage() {
		return coverImage;
	}

	/**
	 * Sets the cover image.
	 *
	 * @param coverImage the new cover image
	 */
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	/**
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * Gets the summary.
	 *
	 * @return the summary
	 */
	@Column(name = "summary")
	@Type(type = "text")
	public String getSummary() {
		return summary;
	}

	/**
	 * Sets the summary.
	 *
	 * @param summary the new summary
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "change_log_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public ChangeLog getChangeLog() {
		return changeLog;
	}

	/**
	 * Sets the change log.
	 *
	 * @param changeLog the new change log
	 */
	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

	/**
	 * Gets the skill resume set.
	 *
	 * @return the skill resume set
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "resume_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	@OrderBy("endorseSet DESC")
	public Set<SkillResume> getSkillResumeSet() {
		return skillResumeSet;
	}

	/**
	 * Sets the skill resume set.
	 *
	 * @param skillResumeSet the new skill resume set
	 */
	public void setSkillResumeSet(Set<SkillResume> skillResumeSet) {
		this.skillResumeSet = skillResumeSet;
	}

}
