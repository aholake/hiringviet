package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.model.Comment;

@Repository
@Transactional
public interface CommentDAO {

	public List<Comment> getListCommentByPostId(Integer postId);
}
