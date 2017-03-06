package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.common.AccountRoleEnum;
import vn.com.hiringviet.dao.CommentDAO;
import vn.com.hiringviet.dao.MemberDAO;
import vn.com.hiringviet.dao.ReplyCommentDAO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.ReplyCommentDTO;
import vn.com.hiringviet.model.Comment;
import vn.com.hiringviet.model.ReplyComment;
import vn.com.hiringviet.service.ReplyCommentService;
import vn.com.hiringviet.util.Utils;

// TODO: Auto-generated Javadoc
/**
 * The Class ReplyCommentServiceImpl.
 */
@Service("replyCommentService")
public class ReplyCommentServiceImpl implements ReplyCommentService{

	/** The reply comment dao. */
	@Autowired
	private ReplyCommentDAO replyCommentDAO;

	/** The member dao. */
	@Autowired
	private MemberDAO memberDAO;

	/** The comment dao. */
	@Autowired
	private CommentDAO commentDAO;

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ReplyCommentService#getListCommentByPostId(java.lang.Integer, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<ReplyCommentDTO> getListCommentByPostId(Integer first, Integer max, Integer commentId) {

		List<ReplyCommentDTO> replyCommentDTOs = replyCommentDAO.getListCommentByPostId(first, max, commentId);

		if (!Utils.isEmptyList(replyCommentDTOs)) {
			for (int i = 0; i < replyCommentDTOs.size(); i++) {
				ReplyCommentDTO replyCommentDTO = replyCommentDTOs.get(i);
				if (AccountRoleEnum.USER == replyCommentDTO.getAccount().getUserRole()) {
					MemberDTO memberDTO = memberDAO.getMemberByAccountId(replyCommentDTO.getAccount().getId());
					replyCommentDTO.setMemberId(memberDTO.getId());
					replyCommentDTO.setFirstName(memberDTO.getFirstName());
					replyCommentDTO.setLastName(memberDTO.getLastName());
					replyCommentDTO.setAvatarImage(memberDTO.getAvatarImage());
				}
			}
		}

		return replyCommentDTOs;
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ReplyCommentService#createReplyComment(vn.com.hiringviet.dto.ReplyCommentDTO)
	 */
	@Override
	public Integer createReplyComment(ReplyCommentDTO replyCommentDTO) {

		Comment comment = commentDAO.findOne(replyCommentDTO.getCommentId());

		ReplyComment replyComment = new ReplyComment();
		replyComment.setAccount(replyCommentDTO.getAccount());
		replyComment.setComment(comment);
		replyComment.setChangeLog(Utils.generatorChangeLog());
		replyComment.setReplyComment(replyCommentDTO.getReplyComment());

		return replyCommentDAO.create(replyComment);
	}

	/* (non-Javadoc)
	 * @see vn.com.hiringviet.service.ReplyCommentService#delete(java.lang.Integer)
	 */
	@Override
	public boolean delete(Integer replyCommentId) {

		return replyCommentDAO.delete(replyCommentId);
	}

}
