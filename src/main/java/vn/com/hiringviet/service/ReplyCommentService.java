package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.ReplyCommentDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReplyCommentService.
 */
@Service("replyCommentService")
public interface ReplyCommentService {

	/**
	 * Gets the list comment by post id.
	 *
	 * @param first the first
	 * @param max the max
	 * @param commentId the comment id
	 * @return the list comment by post id
	 */
	public List<ReplyCommentDTO> getListCommentByPostId(Integer first, Integer max, Integer commentId);

	/**
	 * Creates the reply comment.
	 *
	 * @param replyCommentDTO the reply comment dto
	 * @return the integer
	 */
	public Integer createReplyComment(ReplyCommentDTO replyCommentDTO);

	/**
	 * Delete.
	 *
	 * @param replyCommentId the reply comment id
	 * @return true, if successful
	 */
	public boolean delete(Integer replyCommentId);
}
