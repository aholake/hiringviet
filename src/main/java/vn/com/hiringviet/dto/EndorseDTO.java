package vn.com.hiringviet.dto;

import java.io.Serializable;

public class EndorseDTO implements Serializable {

	private static final long serialVersionUID = 8625187641680304101L;

	private Integer requestEndorseID;

	private MemberDTO fromMemberID;

	private MemberDTO toMemberID;

	private SkillDTO skill;

	private Integer status;

	public Integer getRequestEndorseID() {
		return requestEndorseID;
	}

	public void setRequestEndorseID(Integer requestEndorseID) {
		this.requestEndorseID = requestEndorseID;
	}

	public MemberDTO getFromMemberID() {
		return fromMemberID;
	}

	public void setFromMemberID(MemberDTO fromMemberID) {
		this.fromMemberID = fromMemberID;
	}

	public MemberDTO getToMemberID() {
		return toMemberID;
	}

	public void setToMemberID(MemberDTO toMemberID) {
		this.toMemberID = toMemberID;
	}

	public SkillDTO getSkill() {
		return skill;
	}

	public void setSkill(SkillDTO skill) {
		this.skill = skill;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
