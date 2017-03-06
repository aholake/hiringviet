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
 * The Class Connect.
 */
@Entity
@Table(name = "connect")
public class Connect implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4719386124548469927L;

	/** The id. */
	private Integer id;

	/** The from member. */
	private Member fromMember;

	/** The to member. */
	private Member toMember;

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
	 * Gets the from member.
	 *
	 * @return the from member
	 */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_member")
	public Member getFromMember() {
		return fromMember;
	}

	/**
	 * Sets the from member.
	 *
	 * @param fromMember the new from member
	 */
	public void setFromMember(Member fromMember) {
		this.fromMember = fromMember;
	}

	/**
	 * Gets the to member.
	 *
	 * @return the to member
	 */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_member")
	public Member getToMember() {
		return toMember;
	}

	/**
	 * Sets the to member.
	 *
	 * @param toMember the new to member
	 */
	public void setToMember(Member toMember) {
		this.toMember = toMember;
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
