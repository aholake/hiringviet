package vn.com.hiringviet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.hiringviet.common.MemberRoleEnum;
import vn.com.hiringviet.dao.MemberDAO;
import vn.com.hiringviet.dao.ReplyCommentDAO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.ReplyCommentDTO;
import vn.com.hiringviet.service.ReplyCommentService;
import vn.com.hiringviet.util.Utils;

@Service("replyCommentService")
public class ReplyCommentServiceImpl implements ReplyCommentService{

	@Autowired
	private ReplyCommentDAO replyCommentDAO;

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List<ReplyCommentDTO> getListCommentByPostId(Integer first, Integer max, Integer commentId) {

		List<ReplyCommentDTO> replyCommentDTOs = replyCommentDAO.getListCommentByPostId(first, max, commentId);

		if (!Utils.isEmptyList(replyCommentDTOs)) {
			for (int i = 0; i < replyCommentDTOs.size(); i++) {
				ReplyCommentDTO replyCommentDTO = replyCommentDTOs.get(i);
				if (MemberRoleEnum.USER.getValue() == replyCommentDTO.getAccount().getRoleID()) {
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

}
