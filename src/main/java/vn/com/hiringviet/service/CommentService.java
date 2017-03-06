package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.CommentDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CommentService.
 */
@Service("commentService")
public interface CommentService {

	/**
	 * Gets the list comment.
	 *
	 * @param first the first
	 * @param max the max
	 * @param Id the id
	 * @param isPost the is post
	 * @return the list comment
	 */
	public List<CommentDTO> getListComment(Integer first, Integer max, Integer Id, boolean isPost);

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
