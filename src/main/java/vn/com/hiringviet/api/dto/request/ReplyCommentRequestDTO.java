package vn.com.hiringviet.api.dto.request;

import java.io.Serializable;

import vn.com.hiringviet.dto.PagingDTO;

public class ReplyCommentRequestDTO implements Serializable {

	private static final long serialVersionUID = -935398607055100767L;

	private Integer commentId;

	private PagingDTO pagingDTO;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public PagingDTO getPagingDTO() {
		return pagingDTO;
	}

	public void setPagingDTO(PagingDTO pagingDTO) {
		this.pagingDTO = pagingDTO;
	}

}
