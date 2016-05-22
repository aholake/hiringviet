package vn.com.hiringviet.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RequestEndorseDTO implements Serializable {

	private static final long serialVersionUID = 2211702272100720337L;

	private Integer requestEndorseID;

	private MemberDTO fromMemberID;

	private MemberDTO toMemberID;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
