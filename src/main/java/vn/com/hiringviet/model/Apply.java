package vn.com.hiringviet.model;

import java.io.Serializable;

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

import org.hibernate.annotations.Type;

// TODO: Auto-generated Javadoc
/**
 * The Class Apply.
 */
@Entity
@Table(name = "apply")
public class Apply implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8790898850284130257L;

	/** The apply id. */
	private Integer applyID;

	/** The member. */
	private Member member;

	/** The curriculum vitae. */
	private String curriculumVitae;

	/** The job. */
	private Job job;

	/** The disscription. */
	private String disscription;

	/** The change log. */
	private ChangeLog changeLog;

	/** The accepted. */
	private Boolean accepted;

	/**
	 * Gets the apply id.
	 *
	 * @return the apply id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getApplyID() {
		return applyID;
	}

	/**
	 * Sets the apply id.
	 *
	 * @param applyID the new apply id
	 */
	public void setApplyID(Integer applyID) {
		this.applyID = applyID;
	}

	/**
	 * Gets the member.
	 *
	 * @return the member
	 */
	@ManyToOne(cascade = CascadeType.ALL)
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
	 * Gets the job.
	 *
	 * @return the job
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "job_id")
	public Job getJob() {
		return job;
	}

	/**
	 * Sets the job.
	 *
	 * @param job the new job
	 */
	public void setJob(Job job) {
		this.job = job;
	}

	/**
	 * Gets the curriculum vitae.
	 *
	 * @return the curriculum vitae
	 */
	@Column(name = "curriculum_vitae")
	public String getCurriculumVitae() {
		return curriculumVitae;
	}

	/**
	 * Sets the curriculum vitae.
	 *
	 * @param curriculumVitae the new curriculum vitae
	 */
	public void setCurriculumVitae(String curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

	/**
	 * Gets the disscription.
	 *
	 * @return the disscription
	 */
	@Column(name = "description")
	@Type(type = "text")
	public String getDisscription() {
		return disscription;
	}

	/**
	 * Sets the disscription.
	 *
	 * @param disscription the new disscription
	 */
	public void setDisscription(String disscription) {
		this.disscription = disscription;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "change_log_id")
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
	 * Gets the accepted.
	 *
	 * @return the accepted
	 */
	@Column(name = "accepted", nullable = true)
	public Boolean getAccepted() {
		return accepted;
	}

	/**
	 * Sets the accepted.
	 *
	 * @param isAccepted the new accepted
	 */
	public void setAccepted(Boolean isAccepted) {
		this.accepted = isAccepted;
	}
}
