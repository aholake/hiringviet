package vn.com.hiringviet.api.dto.request;

import java.io.Serializable;

import vn.com.hiringviet.dto.PagingDTO;

/**
 * The Class ReplyCommentRequestDTO.
 */
public class ReplyCommentRequestDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -935398607055100767L;

	/** The comment id. */
	private Integer commentId;

	/** The paging dto. */
	private PagingDTO pagingDTO;

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

}
