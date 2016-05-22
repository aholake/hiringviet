package vn.com.hiringviet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ENDORSE", catalog = "hiringviet")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Endorse implements Serializable {

	private static final long serialVersionUID = 8625187641680304101L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ENDORSE_ID", unique = true, nullable = false, length = 11)
	private Integer endorseID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FROM_MEMBER_ID", nullable = false)
	private Member fromMemberID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TO_MEMBER_ID", nullable = false)
	private Member toMemberID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SKILL_ID", nullable = false)
	private Skill skill;

	@Column(name = "STATUS", nullable = false)
	private Integer status;

	public Integer getEndorseID() {
		return endorseID;
	}

	public void setEndorseID(Integer endorseID) {
		this.endorseID = endorseID;
	}

	public Member getFromMemberID() {
		return fromMemberID;
	}

	public void setFromMemberID(Member fromMemberID) {
		this.fromMemberID = fromMemberID;
	}

	public Member getToMemberID() {
		return toMemberID;
	}

	public void setToMemberID(Member toMemberID) {
		this.toMemberID = toMemberID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
