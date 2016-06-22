package vn.com.hiringviet.api.dto.request;

import java.io.Serializable;

import vn.com.hiringviet.dto.PagingDTO;

public class CommentRequestDTO implements Serializable {

	private static final long serialVersionUID = -841618414612734059L;

	private Integer postId;

	private Integer jobId;

	private PagingDTO pagingDTO;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public PagingDTO getPagingDTO() {
		return pagingDTO;
	}

	public void setPagingDTO(PagingDTO pagingDTO) {
		this.pagingDTO = pagingDTO;
	}

}
