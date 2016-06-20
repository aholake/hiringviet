package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CommentDAO;
import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	@Override
	public List<CommentDTO> getListCommentByPostId(Integer first, Integer max, Integer postId) {

		return commentDAO.getListCommentByPostId(first, max, postId);
	}

}
