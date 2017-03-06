package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.ReplyCommentDTO;
import vn.com.hiringviet.model.ReplyComment;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReplyCommentDAO.
 */
@Repository
@Transactional
public interface ReplyCommentDAO extends CommonDAO<ReplyComment> {

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
	 * Delete.
	 *
	 * @param replyCommentId the reply comment id
	 * @return true, if successful
	 */
	public boolean delete(Integer replyCommentId);
}
