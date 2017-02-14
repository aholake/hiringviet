package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.ReplyCommentDTO;
import vn.com.hiringviet.model.ReplyComment;

@Repository
@Transactional
public interface ReplyCommentDAO extends CommonDAO<ReplyComment> {

	public List<ReplyCommentDTO> getListCommentByPostId(Integer first, Integer max, Integer commentId);

	public boolean delete(Integer replyCommentId);
}
