package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.model.Comment;

@Repository
@Transactional
public interface CommentDAO extends CommonDAO<Comment> {

	public List<CommentDTO> getListComment(Integer first, Integer max, Integer id, boolean isPost);

	public Integer create(CommentDTO commentDTO);
}
