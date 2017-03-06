package vn.com.hiringviet.api.dto.request;

import java.io.Serializable;

import vn.com.hiringviet.dto.PagingDTO;

/**
 * The Class CommentRequestDTO.
 */
public class CommentRequestDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -841618414612734059L;

	/** The post id. */
	private Integer postId;

	/** The job id. */
	private Integer jobId;

	/** The paging dto. */
	private PagingDTO pagingDTO;

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
	 * Gets the job id.
	 *
	 * @return the job id
	 */
	public Integer getJobId() {
		return jobId;
	}

	/**
	 * Sets the job id.
	 *
	 * @param jobId the new job id
	 */
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
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
