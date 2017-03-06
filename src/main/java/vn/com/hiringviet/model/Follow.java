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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Follow.
 */
@Entity
@Table(name = "follow")
public class Follow implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8097651282212896550L;

	/** The id. */
	private Integer id;

	/** The from account. */
	private Account fromAccount;

	/** The to account. */
	private Account toAccount;

	/** The change log. */
	private ChangeLog changeLog;

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
	 * Gets the from account.
	 *
	 * @return the from account
	 */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_account")
	public Account getFromAccount() {
		return fromAccount;
	}

	/**
	 * Sets the from account.
	 *
	 * @param fromAccount the new from account
	 */
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	/**
	 * Gets the to account.
	 *
	 * @return the to account
	 */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_account")
	public Account getToAccount() {
		return toAccount;
	}

	/**
	 * Sets the to account.
	 *
	 * @param toAccount the new to account
	 */
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "change_log_id")
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
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

}
