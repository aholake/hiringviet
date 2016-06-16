package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CommentDAO;
import vn.com.hiringviet.model.Comment;
import vn.com.hiringviet.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	@Override
	public List<Comment> getListCommentByPostId(Integer postId) {
		// TODO Auto-generated method stub
		return commentDAO.getListCommentByPostId(postId);
	}

}
