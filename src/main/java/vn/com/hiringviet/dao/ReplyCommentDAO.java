package vn.com.hiringviet.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dto.ReplyCommentDTO;

@Repository
@Transactional
public interface ReplyCommentDAO {

	public List<ReplyCommentDTO> getListCommentByPostId(Integer first, Integer max, Integer commentId);
}
