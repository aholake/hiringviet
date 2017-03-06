package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

// TODO: Auto-generated Javadoc
/**
 * The Class Endorse.
 */
@Entity
@Table(name = "endorse")
public class Endorse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5124721730324405041L;

	/** The id. */
	private Integer id;

	/** The account. */
	private Account account;

	/** The created date. */
	private Date createdDate;

	/** The skill resume. */
	private SkillResume skillResume;

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
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "account_id")
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
	 * Gets the skill resume.
	 *
	 * @return the skill resume
	 */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_resume_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public SkillResume getSkillResume() {
		return skillResume;
	}

	/**
	 * Sets the skill resume.
	 *
	 * @param skillResume the new skill resume
	 */
	public void setSkillResume(SkillResume skillResume) {
		this.skillResume = skillResume;
	}

}
