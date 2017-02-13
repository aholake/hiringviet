package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.ReplyCommentDTO;

@Service("replyCommentService")
public interface ReplyCommentService {

	public List<ReplyCommentDTO> getListCommentByPostId(Integer first, Integer max, Integer commentId);

	public Integer createReplyComment(ReplyCommentDTO replyCommentDTO);

	public boolean delete(Integer replyCommentId);
}
