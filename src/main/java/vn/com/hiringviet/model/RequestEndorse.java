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
@Table(name = "REQUEST_ENDORSE", catalog = "hiringviet")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class RequestEndorse implements Serializable {

	private static final long serialVersionUID = 8625187641680304101L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "REQUEST_ENDORSE_ID", unique = true, nullable = false, length = 11)
	private Integer requestEndorseID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FROM_MEMBER_ID", nullable = false)
	private Member fromMemberID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TO_MEMBER_ID", nullable = false)
	private Member toMemberID;

	@Column(name = "STATUS", nullable = false)
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
