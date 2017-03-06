package vn.com.hiringviet.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Post.
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7332349673180731226L;

	/** The id. */
	private Integer id;

	/** The company. */
	private Company company;

	/** The title. */
	private String title;

	/** The description. */
	private String description;

	/** The change log. */
	private ChangeLog changeLog;

	/** The comment set. */
	private Set<Comment> commentSet;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	 * Gets the company.
	 *
	 * @return the company
	 */
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	public Company getCompany() {
		return company;
	}

	/**
	 * Sets the company.
	 *
	 * @param company the new company
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the change log.
	 *
	 * @return the change log
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "change_log_id")
	@OrderBy("createdDate")
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

	/**
	 * Gets the comment set.
	 *
	 * @return the comment set
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "post_id")
	public Set<Comment> getCommentSet() {
		return commentSet;
	}

	/**
	 * Sets the comment set.
	 *
	 * @param commentSet the new comment set
	 */
	public void setCommentSet(Set<Comment> commentSet) {
		this.commentSet = commentSet;
	}
}
