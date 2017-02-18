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

@Entity
@Table(name = "apply")
public class Apply implements Serializable {

	private static final long serialVersionUID = 8790898850284130257L;

	private Integer applyID;

	private Member member;

	private String curriculumVitae;

	private Job job;

	private String disscription;

	private ChangeLog changeLog;

	private boolean accepted;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getApplyID() {
		return applyID;
	}

	public void setApplyID(Integer applyID) {
		this.applyID = applyID;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id")
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "job_id")
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Column(name = "curriculum_vitae")
	public String getCurriculumVitae() {
		return curriculumVitae;
	}

	public void setCurriculumVitae(String curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}

	@Column(name = "description")
	@Type(type = "text")
	public String getDisscription() {
		return disscription;
	}

	public void setDisscription(String disscription) {
		this.disscription = disscription;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "change_log_id")
	public ChangeLog getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(ChangeLog changeLog) {
		this.changeLog = changeLog;
	}

	@Column(name="accepted")
	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.accepted = isAccepted;
	}
}
