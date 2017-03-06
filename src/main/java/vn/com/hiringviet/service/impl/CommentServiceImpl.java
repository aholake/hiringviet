package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.dao.CommentDAO;
import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.dao.PostDAO;
import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.service.CommentService;

// TODO: Auto-generated Javadoc
/**
 * The Class CommentServiceImpl.
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

	/** The comment dao. */
	@Autowired
	private CommentDAO commentDAO;

	/** The post dao. */
	@Autowired
	private PostDAO postDAO;

	/** The job dao. */
	@Autowired
	private JobDAO jobDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CommentService#getListComment(java.lang.Integer, java.lang.Integer, java.lang.Integer, boolean)
	 */
	@Override
	public List<CommentDTO> getListComment(Integer first, Integer max, Integer id, boolean isPost) {

		return commentDAO.getListComment(first, max, id, isPost);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CommentService#create(vn.com.hiringviet.dto.CommentDTO)
	 */
	@Override
	public Integer create(CommentDTO commentDTO) {

//		Comment comment = new Comment();
//		comment.setChangeLog(Utils.generatorChangeLog());
//		comment.setComment(commentDTO.getComment());
//		comment.setMember(commentDTO.getMember());
//
//		if (!Utils.isEmptyNumber(commentDTO.getPostId())) {
//			Post post = postDAO.findOne(commentDTO.getPostId());
//			post.setId(commentDTO.getPostId());
//			comment.setPost(post);;
//		}
//		
//		if (!Utils.isEmptyNumber(commentDTO.getJobId())) {
////			Job job = jobDAO.findOne(commentDTO.getJobId());
//			Job job = new Job();
//			job.setId(commentDTO.getJobId());
//			comment.setJob(job);
//		}

		return commentDAO.create(commentDTO);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.CommentService#delete(java.lang.Integer)
	 */
	@Override
	public boolean delete(Integer commentId) {

		return commentDAO.delete(commentId);
	}

}
