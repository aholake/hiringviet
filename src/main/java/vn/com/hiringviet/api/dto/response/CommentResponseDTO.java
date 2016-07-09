package vn.com.hiringviet.api.dto.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.dto.PagingDTO;

public class CommentResponseDTO extends CommonResponseDTO implements
		Serializable {

	private static final long serialVersionUID = -519232514569008578L;

	private List<CommentDTO> commentDTOs;

	private PagingDTO pagingDTO;

	private boolean isLoadable;

	private String avatarImage;

	private Integer memberId;

	private String firstName;

	private String lastName;

	private Date now;

	private String comment;

	private Integer commentId;

	private Integer postId;

	private Integer companyId;

	private Integer roleId;

	public List<CommentDTO> getCommentDTOs() {
		return commentDTOs;
	}

	public void setCommentDTOs(List<CommentDTO> commentDTOs) {
		this.commentDTOs = commentDTOs;
	}

	public PagingDTO getPagingDTO() {
		return pagingDTO;
	}

	public void setPagingDTO(PagingDTO pagingDTO) {
		this.pagingDTO = pagingDTO;
	}

	public boolean isLoadable() {
		return isLoadable;
	}

	public void setLoadable(boolean isLoadable) {
		this.isLoadable = isLoadable;
	}

	public String getAvatarImage() {
		return avatarImage;
	}

	public void setAvatarImage(String avatarImage) {
		this.avatarImage = avatarImage;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getNow() {
		return now;
	}

	public void setNow(Date now) {
		this.now = now;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
