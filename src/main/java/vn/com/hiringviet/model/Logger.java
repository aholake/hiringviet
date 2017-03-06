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

// TODO: Auto-generated Javadoc
/**
 * The Class Logger.
 */
@Entity
@Table(name = "logger")
public class Logger implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3998705197273283946L;

	/** The id. */
	private Integer id;

	/** The account. */
	private Account account;

	/** The info. */
	private String info;

	/** The type. */
	private Boolean type;

	/** The date time. */
	private Date dateTime;

	/** The image. */
	private String image;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
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
	 * Gets the info.
	 *
	 * @return the info
	 */
	@Column(name = "info")
	public String getInfo() {
		return info;
	}

	/**
	 * Sets the info.
	 *
	 * @param info the new info
	 */
	public void setInfo(String info) {
		this.info = info;
	}

	/**
	 * Gets the date time.
	 *
	 * @return the date time
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_time")
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the date time.
	 *
	 * @param dateTime the new date time
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	@Column(name = "image")
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Gets the account.
	 *
	 * @return the account
	 */
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
	 * Gets the type.
	 *
	 * @return the type
	 */
	@Column(name = "type")
	public Boolean getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(Boolean type) {
		this.type = type;
	}

}
