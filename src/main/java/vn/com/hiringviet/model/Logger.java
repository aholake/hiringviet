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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "logger")
public class Logger implements Serializable {

	private static final long serialVersionUID = -3998705197273283946L;

	private Integer id;

	private Account account;

	private String info;

	private Boolean type;

	private Date dateTime;

	private String image;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "info")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time")
	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Column(name = "image")
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "type")
	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

}
