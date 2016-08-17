package vn.com.hiringviet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.request.CommentRequestDTO;
import vn.com.hiringviet.api.dto.request.ReplyCommentRequestDTO;
import vn.com.hiringviet.api.dto.response.CommentResponseDTO;
import vn.com.hiringviet.api.dto.response.ReplyCommentResponseDTO;
import vn.com.hiringviet.common.AccountRoleEnum;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.dto.PagingDTO;
import vn.com.hiringviet.dto.PostDTO;
import vn.com.hiringviet.dto.ReplyCommentDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.CommentService;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.FollowService;
import vn.com.hiringviet.service.ReplyCommentService;
import vn.com.hiringviet.util.DateUtil;
import vn.com.hiringviet.util.Utils;

/**
 * The Class CompanyController.
 */
@Controller
public class CompanyController {

	/** The company service. */
	@Autowired
	private CompanyService companyService;

	/** The follow service. */
	@Autowired
	private FollowService followService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private ReplyCommentService replyCommentService;
	/**
	 * Go company page.
	 *
	 * @param companyId the company id
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/company/{companyId}", method = RequestMethod.GET)
	public String goCompanyPage(@PathVariable("companyId") Integer companyId, Model model) {

		Company company = companyService.getCompanyById(companyId);
		List<PostDTO> postList = companyService.getListPosts(0, ConstantValues.MAX_RECORD_COUNT, companyId);
		Long numberFollower = followService.countNumberOfFollower(company.getAccount().getId());

		if (ConstantValues.MAX_RECORD_COUNT > postList.size()) {
			model.addAttribute("isDisabledLoadPosts", true);
		}

		model.addAttribute("postList", postList);
		model.addAttribute("company", company);
		model.addAttribute("numberFollower", numberFollower);
		return "company";
	}

	/**
	 * Go company carrers page.
	 *
	 * @param companyId the company id
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/company/{companyId}/job", method = RequestMethod.GET)
	public String goCompanyCarrersPage(@PathVariable("companyId") Integer companyId, Model model) {

		Company company = companyService.getCompanyById(companyId);
		List<Job> jobList = companyService.getListJob(0, ConstantValues.MAX_RECORD_COUNT, companyId);

		if (ConstantValues.MAX_RECORD_COUNT > jobList.size()) {
			model.addAttribute("isDisabledLoadJob", true);
		}

		model.addAttribute("jobList", jobList);
		model.addAttribute("company", company);
		return "company-careers";
	}

	/**
	 * Go company banner.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/layouts/companyBanner", method = RequestMethod.GET)
	public String goCompanyBanner() {

		return "/layouts/company_banner";
	}

	/**
	 * Go company header.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/layouts/companyHeader", method = RequestMethod.GET)
	public String goCompanyHeader() {

		return "/layouts/company_header";
	}

	@RequestMapping(value = {"/company/post/comments", "/company/careers/comments"}, method = RequestMethod.POST)
	public @ResponseBody CommentResponseDTO getComment(@RequestBody CommentRequestDTO commentRequestDTO) {

		CommentResponseDTO commentResponseDTO = new CommentResponseDTO();

		PagingDTO pagingDTO = null;
		if (ConstantValues.CURRENT_PAGE == commentRequestDTO.getPagingDTO().getCurrentPage()) {
			pagingDTO = Utils.calculatorPaging(commentRequestDTO.getPagingDTO(), true);
		} else {
			pagingDTO = commentRequestDTO.getPagingDTO();
		}

		List<CommentDTO> commentDTOs = null;

		if (!Utils.isEmptyNumber(commentRequestDTO.getPostId())) {
			commentDTOs = commentService.getListComment(
				pagingDTO.getFirstItem(), ConstantValues.MAX_RECORD_COUNT,
				commentRequestDTO.getPostId(), true);
		}
		
		if (!Utils.isEmptyNumber(commentRequestDTO.getJobId())) {
			commentDTOs = commentService.getListComment(
					pagingDTO.getFirstItem(), ConstantValues.MAX_RECORD_COUNT,
					commentRequestDTO.getJobId(), false);
		}

		if (Utils.isEmptyList(commentDTOs)) {
			commentResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return commentResponseDTO;
		}

		if (commentDTOs.size() < ConstantValues.MAX_RECORD_COUNT) {
			commentResponseDTO.setLoadable(false);
		}


		pagingDTO = Utils.calculatorPaging(commentRequestDTO.getPagingDTO(), false);
		commentResponseDTO.setCommentDTOs(commentDTOs);
		commentResponseDTO.setPagingDTO(pagingDTO);
		commentResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return commentResponseDTO;
	}

	@RequestMapping(value = "/company/post/replyComments", method = RequestMethod.POST)
	public @ResponseBody ReplyCommentResponseDTO getReplyComment(
			@RequestBody ReplyCommentRequestDTO replyCommentRequestDTO) {

		ReplyCommentResponseDTO replyCommentResponseDTO = new ReplyCommentResponseDTO();

		PagingDTO pagingDTO = null;
		if (ConstantValues.CURRENT_PAGE == replyCommentRequestDTO.getPagingDTO().getCurrentPage()) {
			pagingDTO = Utils.calculatorPaging(replyCommentRequestDTO.getPagingDTO(), true);
		} else {
			pagingDTO = replyCommentRequestDTO.getPagingDTO();
		}

		List<ReplyCommentDTO> replyCommentDTOs = replyCommentService.getListCommentByPostId(pagingDTO.getFirstItem(), 
																							ConstantValues.MAX_RECORD_COUNT, 
																							replyCommentRequestDTO.getCommentId());

		if (Utils.isEmptyList(replyCommentDTOs)) {
			replyCommentResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return replyCommentResponseDTO;
		}

		if (replyCommentDTOs.size() < ConstantValues.MAX_RECORD_COUNT) {
			replyCommentResponseDTO.setLoadable(false);
		}

		pagingDTO = Utils.calculatorPaging(replyCommentRequestDTO.getPagingDTO(), false);
		replyCommentResponseDTO.setReplyCommentDTOs(replyCommentDTOs);
		replyCommentResponseDTO.setPagingDTO(pagingDTO);
		replyCommentResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return replyCommentResponseDTO;
	}

	@RequestMapping(value = "/company/addComment", method = RequestMethod.POST)
	public @ResponseBody CommentResponseDTO addComment(@RequestBody CommentDTO commentDTO) {

		CommentResponseDTO commentResponseDTO = new CommentResponseDTO();

		Account account = getLoggedAccount();
		Member member = account.getMember();

		commentResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		if (!Utils.isEmptyObject(member)) {
			commentDTO.setMember(member);
			if (!Utils.isEmptyNumber(commentService.create(commentDTO))) {
				commentResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
				commentResponseDTO.setAvatarImage(account.getAvatarImage());
				commentResponseDTO.setComment(commentDTO.getComment());
				commentResponseDTO.setFirstName(member.getFirstName());
				commentResponseDTO.setLastName(member.getLastName());
				commentResponseDTO.setMemberId(member.getId());
				commentResponseDTO.setNow(DateUtil.now());
				commentResponseDTO.setPostId(commentDTO.getPostId());
			}
		}

		return commentResponseDTO;
	}

	@RequestMapping(value = "/company/addReplyComment", method = RequestMethod.POST)
	public @ResponseBody CommentResponseDTO addReplyComment(@RequestBody ReplyCommentDTO replyCommentDTO) {

		CommentResponseDTO commentResponseDTO = new CommentResponseDTO();

		Account account = getLoggedAccount();

		commentResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());

		if (account == null) {
			commentResponseDTO.setMessage("Please login to continue");
			return commentResponseDTO;
		}

		replyCommentDTO.setAccount(account);

		Member member = null;
		Company company = null;

		if (AccountRoleEnum.USER == account.getUserRole()) {
			member = account.getMember();
		}

		if (AccountRoleEnum.COMPANY == account.getUserRole()) {
			company = account.getCompany();
		}

		if (!Utils.isEmptyNumber(replyCommentService.createReplyComment(replyCommentDTO))) {
			commentResponseDTO.setAvatarImage(account.getAvatarImage());
			commentResponseDTO.setNow(DateUtil.now());
			commentResponseDTO.setComment(replyCommentDTO.getReplyComment());
			commentResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
			commentResponseDTO.setRoleId(account.getUserRole().getValue());
			commentResponseDTO.setCommentId(replyCommentDTO.getCommentId());

			if (AccountRoleEnum.USER == account.getUserRole()) {
				commentResponseDTO.setFirstName(member.getFirstName());
				commentResponseDTO.setLastName(member.getLastName());
				commentResponseDTO.setMemberId(member.getId());
			}

			if (AccountRoleEnum.COMPANY == account.getUserRole()) {
				commentResponseDTO.setFirstName(company.getDisplayName());
				commentResponseDTO.setCompanyId(company.getId());
			}
		}

		return commentResponseDTO;
	}

	private Account getLoggedAccount() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof Account) {
			Account loginedAccount = (Account) principal;
			return loginedAccount;
		}
		return null;
	}
}
