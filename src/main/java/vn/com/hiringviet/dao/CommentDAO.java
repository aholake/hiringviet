package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.CommentDTO;

@Repository
@Transactional
public interface CommentDAO {

	public List<CommentDTO> getListCommentByPostId(Integer first, Integer max, Integer postId);
}
