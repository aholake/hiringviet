package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.model.Comment;

@Service("commentService")
public interface CommentService {

	public List<Comment> getListCommentByPostId(Integer postId);
}
