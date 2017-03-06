package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import vn.com.hiringviet.common.StatusEnum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangeLog.
 */
@Entity
@Table(name = "change_log")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ChangeLog implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -393256196794848432L;

	/** The id. */
	private int id;

	/** The created date. */
	private Date createdDate;

	/** The updated date. */
	private Date updatedDate;

	/** The deleted date. */
	private Date deletedDate;

	/** The status. */
	private StatusEnum status;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
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
	 * Gets the updated date.
	 *
	 * @return the updated date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate the new updated date
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * Gets the deleted date.
	 *
	 * @return the deleted date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_date")
	public Date getDeletedDate() {
		return deletedDate;
	}

	/**
	 * Sets the deleted date.
	 *
	 * @param deletedDate the new deleted date
	 */
	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	public StatusEnum getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(StatusEnum status) {
		this.status = status;
	}

}
