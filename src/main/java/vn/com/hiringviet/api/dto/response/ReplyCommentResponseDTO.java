package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;
import java.util.List;

import vn.com.hiringviet.dto.PagingDTO;
import vn.com.hiringviet.dto.ReplyCommentDTO;

// TODO: Auto-generated Javadoc
/**
 * The Class ReplyCommentResponseDTO.
 */
public class ReplyCommentResponseDTO extends CommonResponseDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8726056284162105362L;

	/** The reply comment dt os. */
	private List<ReplyCommentDTO> replyCommentDTOs;

	/** The paging dto. */
	private PagingDTO pagingDTO;

	/** The is loadable. */
	private boolean isLoadable;

	/**
	 * Gets the reply comment dt os.
	 *
	 * @return the reply comment dt os
	 */
	public List<ReplyCommentDTO> getReplyCommentDTOs() {
		return replyCommentDTOs;
	}

	/**
	 * Sets the reply comment dt os.
	 *
	 * @param replyCommentDTOs the new reply comment dt os
	 */
	public void setReplyCommentDTOs(List<ReplyCommentDTO> replyCommentDTOs) {
		this.replyCommentDTOs = replyCommentDTOs;
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

}
