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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Member.
 */
@Entity
@Table(name = "member")
public class Member implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;

	/** The account. */
	private Account account;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The full name. */
	private String fullName;

	/** The birth date. */
	private Date birthDate;

	/** The resume. */
	private Resume resume;

	/** The apply set. */
	private Set<Apply> applySet;

	/** The change log. */
	private ChangeLog changeLog;

	/** The from connect set. */
	private Set<Connect> fromConnectSet;

	/** The to connect set. */
	private Set<Connect> toConnectSet;

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
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
	@Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Account getAccount() {
		return account;
	}

	/**
	 * Sets the account.
	 *
	 * @param account the new account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * Gets the resume.
	 *
	 * @return the resume
	 */
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "member", cascade = CascadeType.ALL)
	public Resume getResume() {
		return resume;
	}

	/**
	 * Sets the resume.
	 *
	 * @param resume the new resume
	 */
	public void setResume(Resume resume) {
		this.resume = resume;
	}

	/**
	 * Gets the apply set.
	 *
	 * @return the apply set
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Apply> getApplySet() {
		return applySet;
	}

	/**
	 * Sets the apply set.
	 *
	 * @param applySet the new apply set
	 */
	public void setApplySet(Set<Apply> applySet) {
		this.applySet = applySet;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@OneToOne(fetch = FetchType.EAGER)
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
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	@Formula("first_name || ' ' || last_name")
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 *
	 * @param fullName the new full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Gets the from connect set.
	 *
	 * @return the from connect set
	 */
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "fromMember")
	public Set<Connect> getFromConnectSet() {
		return fromConnectSet;
	}

	/**
	 * Sets the from connect set.
	 *
	 * @param fromConnectSet the new from connect set
	 */
	public void setFromConnectSet(Set<Connect> fromConnectSet) {
		this.fromConnectSet = fromConnectSet;
	}

	/**
	 * Gets the to connect set.
	 *
	 * @return the to connect set
	 */
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "toMember")
	public Set<Connect> getToConnectSet() {
		return toConnectSet;
	}

	/**
	 * Sets the to connect set.
	 *
	 * @param toConnectSet the new to connect set
	 */
	public void setToConnectSet(Set<Connect> toConnectSet) {
		this.toConnectSet = toConnectSet;
	}

}
