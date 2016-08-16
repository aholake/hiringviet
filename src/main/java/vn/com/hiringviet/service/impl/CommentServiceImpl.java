package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CommentDAO;
import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.dao.PostDAO;
import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.model.Comment;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Post;
import vn.com.hiringviet.service.CommentService;
import vn.com.hiringviet.util.Utils;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;

	@Autowired
	private PostDAO postDAO;

	@Autowired
	private JobDAO jobDAO;

	@Override
	public List<CommentDTO> getListComment(Integer first, Integer max, Integer id, boolean isPost) {

		return commentDAO.getListComment(first, max, id, isPost);
	}

	@Override
	public Integer create(CommentDTO commentDTO) {

		Comment comment = new Comment();
		comment.setChangeLog(Utils.generatorChangeLog());
		comment.setComment(commentDTO.getComment());
		comment.setMember(commentDTO.getMember());

		if (!Utils.isEmptyNumber(commentDTO.getPostId())) {
			Post post = postDAO.findOne(commentDTO.getPostId());
			post.setId(commentDTO.getPostId());
			comment.setPost(post);;
		}
		
		if (!Utils.isEmptyNumber(commentDTO.getJobId())) {
			Job job = jobDAO.findOne(commentDTO.getJobId());
			job.setId(commentDTO.getJobId());
			comment.setJob(job);
		}

		return commentDAO.create(comment);
	}

}
