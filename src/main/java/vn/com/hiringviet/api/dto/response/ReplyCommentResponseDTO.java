package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;
import java.util.List;

import vn.com.hiringviet.dto.PagingDTO;
import vn.com.hiringviet.dto.ReplyCommentDTO;

public class ReplyCommentResponseDTO extends CommonResponseDTO implements Serializable {

	private static final long serialVersionUID = 8726056284162105362L;

	private List<ReplyCommentDTO> replyCommentDTOs;

	private PagingDTO pagingDTO;

	private boolean isLoadable;

	public List<ReplyCommentDTO> getReplyCommentDTOs() {
		return replyCommentDTOs;
	}

	public void setReplyCommentDTOs(List<ReplyCommentDTO> replyCommentDTOs) {
		this.replyCommentDTOs = replyCommentDTOs;
	}

	public PagingDTO getPagingDTO() {
		return pagingDTO;
	}

	public void setPagingDTO(PagingDTO pagingDTO) {
		this.pagingDTO = pagingDTO;
	}

	public boolean isLoadable() {
		return isLoadable;
	}

	public void setLoadable(boolean isLoadable) {
		this.isLoadable = isLoadable;
	}

}
