package vn.com.hiringviet.dto;

import java.io.Serializable;

import vn.com.hiringviet.model.Member;

public class RequestEndorseDTO implements Serializable {

	private static final long serialVersionUID = 2211702272100720337L;

	private Integer requestEndorseID;

	private Member fromMemberID;

	private Member toMemberID;

	private Integer status;

	public Integer getRequestEndorseID() {
		return requestEndorseID;
	}

	public void setRequestEndorseID(Integer requestEndorseID) {
		this.requestEndorseID = requestEndorseID;
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

}
