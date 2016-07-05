package vn.com.hiringviet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import vn.com.hiringviet.api.dto.response.CommonResponseDTO;
import vn.com.hiringviet.api.dto.response.ReplyCommentResponseDTO;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.dto.PagingDTO;
import vn.com.hiringviet.dto.ReplyCommentDTO;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.model.Post;
import vn.com.hiringviet.service.CommentService;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.FollowService;
import vn.com.hiringviet.service.ReplyCommentService;
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
	public String goCompanyPage(@PathVariable("companyId") Integer companyId, Model model, HttpSession session) {

		Company company = companyService.findOne(companyId);
		List<Post> postList = companyService.getListPosts(0, ConstantValues.MAX_RECORD_COUNT, companyId);
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
	public String goCompanyCarrersPage(@PathVariable("companyId") Integer companyId, Model model, HttpSession session) {

		Company company = companyService.findOne(companyId);
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
	public String goCompanyBanner(Model model, HttpSession session) {

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
	public String goCompanyHeader(Model model, HttpSession session) {

		return "/layouts/company_header";
	}

	/**
	 * Go job detail page.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/company/careers/{id}", method = RequestMethod.GET)
	public String goJobDetailPage(Model model, HttpSession session) {

		return "job-detail";
	}

	@RequestMapping(value = "/company/post/comments", method = RequestMethod.POST)
	public @ResponseBody CommentResponseDTO getCommentOfPostByPage(@RequestBody CommentRequestDTO commentRequestDTO, HttpSession session) {

		CommentResponseDTO commentResponseDTO = new CommentResponseDTO();

		PagingDTO pagingDTO = Utils.calculatorPaging(commentRequestDTO.getPagingDTO(), true);
		List<CommentDTO> commentDTOs = commentService.getListCommentByPostId(
				pagingDTO.getFirstItem(), ConstantValues.MAX_RECORD_COUNT,
				commentRequestDTO.getPostId());

		if (Utils.isEmptyList(commentDTOs)) {
			commentResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return commentResponseDTO;
		}

		if (commentDTOs.size() < ConstantValues.MAX_RECORD_COUNT) {
			commentResponseDTO.setLoadable(false);
		}

		commentResponseDTO.setCommentDTOs(commentDTOs);
		commentResponseDTO.setPagingDTO(pagingDTO);
		commentResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return commentResponseDTO;
	}

	@RequestMapping(value = "/company/post/replyComments", method = RequestMethod.POST)
	public @ResponseBody ReplyCommentResponseDTO getReplyCommentOfPostByPage(
			@RequestBody ReplyCommentRequestDTO replyCommentRequestDTO,
			HttpSession session) {

		ReplyCommentResponseDTO replyCommentResponseDTO = new ReplyCommentResponseDTO();

		PagingDTO pagingDTO = Utils.calculatorPaging(replyCommentRequestDTO.getPagingDTO(), true);
		List<ReplyCommentDTO> replyCommentDTOs = replyCommentService
				.getListCommentByPostId(pagingDTO.getFirstItem(),
						ConstantValues.MAX_RECORD_COUNT,
						replyCommentRequestDTO.getCommentId());

		if (Utils.isEmptyList(replyCommentDTOs)) {
			replyCommentResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return replyCommentResponseDTO;
		}

		if (replyCommentDTOs.size() < ConstantValues.MAX_RECORD_COUNT) {
			replyCommentResponseDTO.setLoadable(false);
		}

		replyCommentResponseDTO.setReplyCommentDTOs(replyCommentDTOs);
		replyCommentResponseDTO.setPagingDTO(pagingDTO);
		replyCommentResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return replyCommentResponseDTO;
	}

	@RequestMapping(value = "/company/post/addComment", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO addComment(@RequestBody CommentDTO commentDTO, HttpSession session) {

		CommonResponseDTO commonResponseDTO = new CommentResponseDTO();

		Member member = LoginController.getMemberSession(session);

		commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		if (!Utils.isEmptyObject(member)) {
			commentDTO.setMember(member);
			if (!Utils.isEmptyNumber(commentService.create(commentDTO))) {
				commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
			}
		}

		return commonResponseDTO;
	}
}
