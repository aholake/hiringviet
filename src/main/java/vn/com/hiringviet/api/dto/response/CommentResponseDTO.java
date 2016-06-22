package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;
import java.util.List;

import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.dto.PagingDTO;

public class CommentResponseDTO extends CommonResponseDTO implements Serializable {

	private static final long serialVersionUID = -519232514569008578L;

	private List<CommentDTO> commentDTOs;

	private PagingDTO pagingDTO;

	private boolean isLoadable;

	public List<CommentDTO> getCommentDTOs() {
		return commentDTOs;
	}

	public void setCommentDTOs(List<CommentDTO> commentDTOs) {
		this.commentDTOs = commentDTOs;
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
