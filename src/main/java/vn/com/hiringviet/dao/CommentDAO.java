package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.model.Comment;

// TODO: Auto-generated Javadoc
/**
 * The Interface CommentDAO.
 */
@Repository
@Transactional
public interface CommentDAO extends CommonDAO<Comment> {

	/**
	 * Gets the list comment.
	 *
	 * @param first the first
	 * @param max the max
	 * @param id the id
	 * @param isPost the is post
	 * @return the list comment
	 */
	public List<CommentDTO> getListComment(Integer first, Integer max, Integer id, boolean isPost);

	/**
	 * Creates the.
	 *
	 * @param commentDTO the comment dto
	 * @return the integer
	 */
	public Integer create(CommentDTO commentDTO);

	/**
	 * Delete.
	 *
	 * @param commentId the comment id
	 * @return true, if successful
	 */
	public boolean delete(Integer commentId);
}
