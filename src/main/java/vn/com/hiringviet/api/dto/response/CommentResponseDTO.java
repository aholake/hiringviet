package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.dto.PagingDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentResponseDTO.
 */
public class CommentResponseDTO extends CommonResponseDTO implements
		Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -519232514569008578L;

	/** The comment dt os. */
	private List<CommentDTO> commentDTOs;

	/** The paging dto. */
	private PagingDTO pagingDTO;

	/** The is loadable. */
	private boolean isLoadable;

	/** The avatar image. */
	private String avatarImage;

	/** The member id. */
	private Integer memberId;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The now. */
	private Date now;

	/** The comment. */
	private String comment;

	/** The comment id. */
	private Integer commentId;

	/** The post id. */
	private Integer postId;

	/** The company id. */
	private Integer companyId;

	/** The role id. */
	private Integer roleId;

	/**
	 * Gets the comment dt os.
	 *
	 * @return the comment dt os
	 */
	public List<CommentDTO> getCommentDTOs() {
		return commentDTOs;
	}

	/**
	 * Sets the comment dt os.
	 *
	 * @param commentDTOs the new comment dt os
	 */
	public void setCommentDTOs(List<CommentDTO> commentDTOs) {
		this.commentDTOs = commentDTOs;
	}

	/**
	 * Gets the paging dto.
	 *
	 * @return the paging dto
	 */
	public PagingDTO getPagingDTO() {
		return pagingDTO;
	}

	/**
	 * Sets the paging dto.
	 *
	 * @param pagingDTO the new paging dto
	 */
	public void setPagingDTO(PagingDTO pagingDTO) {
		this.pagingDTO = pagingDTO;
	}

	/**
	 * Checks if is loadable.
	 *
	 * @return true, if is loadable
	 */
	public boolean isLoadable() {
		return isLoadable;
	}

	/**
	 * Sets the loadable.
	 *
	 * @param isLoadable the new loadable
	 */
	public void setLoadable(boolean isLoadable) {
		this.isLoadable = isLoadable;
	}

	/**
	 * Gets the avatar image.
	 *
	 * @return the avatar image
	 */
	public String getAvatarImage() {
		return avatarImage;
	}

	/**
	 * Sets the avatar image.
	 *
	 * @param avatarImage the new avatar image
	 */
	public void setAvatarImage(String avatarImage) {
		this.avatarImage = avatarImage;
	}

	/**
	 * Gets the member id.
	 *
	 * @return the member id
	 */
	public Integer getMemberId() {
		return memberId;
	}

	/**
	 * Sets the member id.
	 *
	 * @param memberId the new member id
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the now.
	 *
	 * @return the now
	 */
	public Date getNow() {
		return now;
	}

	/**
	 * Sets the now.
	 *
	 * @param now the new now
	 */
	public void setNow(Date now) {
		this.now = now;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Gets the comment id.
	 *
	 * @return the comment id
	 */
	public Integer getCommentId() {
		return commentId;
	}

	/**
	 * Sets the comment id.
	 *
	 * @param commentId the new comment id
	 */
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	/**
	 * Gets the post id.
	 *
	 * @return the post id
	 */
	public Integer getPostId() {
		return postId;
	}

	/**
	 * Sets the post id.
	 *
	 * @param postId the new post id
	 */
	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	/**
	 * Gets the company id.
	 *
	 * @return the company id
	 */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * Sets the company id.
	 *
	 * @param companyId the new company id
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
