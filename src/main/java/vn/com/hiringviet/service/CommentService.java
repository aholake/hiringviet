package vn.com.hiringviet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.CommentDTO;

@Service("commentService")
public interface CommentService {

	public List<CommentDTO> getListComment(Integer first, Integer max, Integer Id, boolean isPost);

	public Integer create(CommentDTO commentDTO);
}
