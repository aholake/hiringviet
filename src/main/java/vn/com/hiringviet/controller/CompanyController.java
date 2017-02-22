package vn.com.hiringviet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.request.CommentRequestDTO;
import vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO;
import vn.com.hiringviet.api.dto.request.ReplyCommentRequestDTO;
import vn.com.hiringviet.api.dto.response.AccountDTO;
import vn.com.hiringviet.api.dto.response.CommentResponseDTO;
import vn.com.hiringviet.api.dto.response.CommonResponseDTO;
import vn.com.hiringviet.api.dto.response.JobResponseDTO;
import vn.com.hiringviet.api.dto.response.ReplyCommentResponseDTO;
import vn.com.hiringviet.common.AccountRoleEnum;
import vn.com.hiringviet.common.CommonEnum;
import vn.com.hiringviet.common.ModeEnum;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dto.CommentDTO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.dto.PagingDTO;
import vn.com.hiringviet.dto.PostDTO;
import vn.com.hiringviet.dto.ReplyCommentDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.CompanyPhoto;
import vn.com.hiringviet.model.Follow;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.ApplyService;
import vn.com.hiringviet.service.CommentService;
import vn.com.hiringviet.service.CompanyPhotoService;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.FollowService;
import vn.com.hiringviet.service.JobService;
import vn.com.hiringviet.service.LoggerService;
import vn.com.hiringviet.service.ReplyCommentService;
import vn.com.hiringviet.util.DateUtil;
import vn.com.hiringviet.util.ImageUtil;
import vn.com.hiringviet.util.Utils;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

/**
 * The Class CompanyController.
 */
@Controller
public class CompanyController {

	private static final int LAZY_LOAD_COMPANY_NUMBER = 10;

	@Autowired
	private LoggerService loggerService;

	@Autowired
	private AccountService accountService;

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

	@Autowired
	private JobService jobService;
	
	@Autowired
	private ApplyService applyService;

	@Autowired
	private CompanyPhotoService companyPhotoService;

	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

	/**
	 * Go company page.
	 *
	 * @param companyId
	 *            the company id
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public String goCompanyPage(@RequestParam("companyId") Integer companyId,
			@RequestParam(value = "mode", required = false) String mode,
			Model model,
			HttpSession session) {

		Company company = companyService.getCompanyById(companyId);
		Long numberFollower = followService.countNumberOfFollower(company.getAccount().getId());

		Member memberLogin = null;
		Company companyLogin = null;

		Account account = getLoggedAccount();

		boolean isAll = false;
		if (account != null) {
			memberLogin = account.getMember();
			companyLogin = account.getCompany();

			if (account.getCompany() != null && account.getCompany().getId() == companyId) {
				model.addAttribute("isOwner", 1);
				isAll = true;
			}
		}

		model.addAttribute("memberLogin", memberLogin);

		Company companySession = (Company) session.getAttribute("companySession");

		if (companySession == null) {

			session.setAttribute("companySession", companyLogin);
			model.addAttribute("companyLogin", companyLogin);
		} else {

			model.addAttribute("companyLogin", companySession);
		}


		if (ModeEnum.CAREER.getValue().equals(mode)) {

			List<Job> jobList = companyService.getListJob(ConstantValues.FIRST_RECORD, ConstantValues.MAX_RECORD_COUNT, companyId, isAll);

			if (ConstantValues.MAX_RECORD_COUNT > jobList.size()) {
				model.addAttribute("isDisabledLoadJob", true);
			}

			model.addAttribute("jobList", jobList);

			Map<Job, Long> applyNumbers = new HashMap<>();

			for (Job job : jobList) {
				applyNumbers.put(job, jobService.countApplies(job));
			}
			model.addAttribute("applyNumbers", applyNumbers);

			model.addAttribute("firstItem", 0);
			model.addAttribute("maxItem", ConstantValues.MAX_RECORD_COUNT);
			model.addAttribute("currentPage", ConstantValues.CURRENT_PAGE);
			if (ConstantValues.MAX_RECORD_COUNT > jobList.size()) {
				model.addAttribute("isDisabledLoadJob", true);
			}

		} else {

			List<PostDTO> postList = companyService.getListPosts(ConstantValues.FIRST_RECORD, ConstantValues.MAX_RECORD_COUNT, companyId);

			if (ConstantValues.MAX_RECORD_COUNT > postList.size()) {
				model.addAttribute("isDisabledLoadPosts", true);
			}

			model.addAttribute("postList", postList);
			model.addAttribute("uploadBanner", blobstoreService.createUploadUrl("/company/photo/add"));
		}

		// check follow
		if (memberLogin != null) {
			
			if(accountService.hasFollow(memberLogin.getAccount().getId(), company.getAccount().getId())) {

				model.addAttribute("hasFollow", true);
			}
		}

		model.addAttribute("numberFollower", numberFollower);

		List<JobDTO> newJobs = jobService.getNewJobs(companyId);
		model.addAttribute("newJobs", newJobs);
		
		model.addAttribute("company", company);

		model.addAttribute("fileUpload", blobstoreService.createUploadUrl("/company/image"));
		model.addAttribute("mode", ConstantValues.MODE_COMPANY_HOME);
		
		model.addAttribute("memberDTO", new MemberDTO());
		return "company";	
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
			commentResponseDTO.setPostId(commentRequestDTO.getPostId());
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
		if (ConstantValues.CURRENT_PAGE == replyCommentRequestDTO
				.getPagingDTO().getCurrentPage()) {
			pagingDTO = Utils.calculatorPaging(
					replyCommentRequestDTO.getPagingDTO(), true);
		} else {
			pagingDTO = replyCommentRequestDTO.getPagingDTO();
		}

		List<ReplyCommentDTO> replyCommentDTOs = replyCommentService
				.getListCommentByPostId(pagingDTO.getFirstItem(),
						ConstantValues.MAX_RECORD_COUNT,
						replyCommentRequestDTO.getCommentId());

		if (Utils.isEmptyList(replyCommentDTOs)) {
			replyCommentResponseDTO.setResult(StatusResponseEnum.FAIL
					.getStatus());
			return replyCommentResponseDTO;
		}

		if (replyCommentDTOs.size() < ConstantValues.MAX_RECORD_COUNT) {
			replyCommentResponseDTO.setLoadable(false);
		}

		pagingDTO = Utils.calculatorPaging(
				replyCommentRequestDTO.getPagingDTO(), false);
		replyCommentResponseDTO.setReplyCommentDTOs(replyCommentDTOs);
		replyCommentResponseDTO.setPagingDTO(pagingDTO);
		replyCommentResponseDTO.setResult(StatusResponseEnum.SUCCESS
				.getStatus());
		return replyCommentResponseDTO;
	}

	@RequestMapping(value = "/company/addComment", method = RequestMethod.POST)
	public @ResponseBody CommentResponseDTO addComment(@RequestBody CommentDTO commentDTO) {

		CommentResponseDTO commentResponseDTO = new CommentResponseDTO();
		commentResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());

		Account account = getLoggedAccount();
		
		if (account == null)
		{
			return commentResponseDTO;
		}

		Member member = account.getMember();

		if (!Utils.isEmptyObject(member)) {
			commentDTO.setMember(member);
			if (!Utils.isEmptyNumber(commentService.create(commentDTO))) {
				commentResponseDTO.setResult(StatusResponseEnum.SUCCESS
						.getStatus());
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

//			if (replyCommentDTO.getAccountId() != null && account.getId() != replyCommentDTO.getAccountId()) {
//				if(!loggerService.create(account.getId(), null, CommonEnum.REPLY_COMMENT.getStatus())) {
//					commentResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
//				}
//			}

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

	@RequestMapping(value = "/company/getCompanyHot")
	@ResponseBody
	public List<Company> getHotCompanies(@RequestBody int scrollTime) {
		int rowIndex = scrollTime * LAZY_LOAD_COMPANY_NUMBER;
		List<Company> companies = companyService.getListCompany(rowIndex,
				LAZY_LOAD_COMPANY_NUMBER, true);
		return companies;
	}
	
	private Account getLoggedAccount() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof Account) {
			Account loginedAccount = (Account) principal;
			return loginedAccount;
		}
		return null;
	}

	/**
	 * Go job detail page.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/company/careers", method = RequestMethod.GET)
	public String goJobDetailPage(@RequestParam("jobId") Integer jobId, Model model, HttpSession session) {

		jobService.updateVisited(jobId);
		Job job = jobService.getJobById(jobId);
		Long numberFollower = followService.countNumberOfFollower(job.getCompany().getAccount().getId());
		model.addAttribute("job", job);
		model.addAttribute("numberFollower", numberFollower);
		
		Member memberLogin = null;
		Account account = getLoggedAccount();
		model.addAttribute("showUpdate", 0);
		if (account != null) {
			if (account.getMember() != null) {
				memberLogin = account.getMember();
			}
			if (account.getCompany() != null) {
				if(account.getCompany().getId() == job.getCompany().getId()) {
					model.addAttribute("showUpdate", 1);
				}
			}
		}
		model.addAttribute("memberLogin", memberLogin);
		List<JobDTO> newJobs = jobService.getNewJobs(job.getCompany().getId());
		model.addAttribute("newJobs", newJobs);
		return "job-detail";
	}

	@RequestMapping(value = "/company/addPosts", method = RequestMethod.POST)
	public String addPosts(@ModelAttribute PostDTO postDTO, Model model, HttpSession session) {
		
		Company companyLogin = null;

		Account account = getLoggedAccount();
		if (account != null) {
			companyLogin = account.getCompany();
		} else {
			return "redirect:/login";
		}
		
		if (companyLogin != null) {
			companyService.addPosts(postDTO, companyLogin);
			Set<Follow> follows = companyLogin.getAccount().getToFollows();
			for (Follow follow : follows) {
				loggerService.jobActivity(companyLogin.getAccount(), 
						follow.getFromAccount(), 
						companyLogin.getAccount().getAvatarImage(), 
						Utils.genLogFollow(companyLogin, null, false), true);
			}
			return goCompanyPage(companyLogin.getId(), ModeEnum.HOME.getValue(), model, session);
		}
		return "redirect:/login";
	}

	@RequestMapping(value = "/company/image", method = RequestMethod.POST)
	public String uploadAvatarImage(
			@RequestParam("mode") String mode,
			HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session) {

		Company companyLogin = null;
		Account account = getLoggedAccount();
		if (account != null) {
			companyLogin = account.getCompany();
		} else {
			return "redirect:/login";
		}

		AccountDTO accountDTO =  ImageUtil.convertImageToByte(blobstoreService, request, account);
		account.setAvatarImage(accountDTO.getAvatarImage());
		account.setAvatarImageKey(accountDTO.getAvatarImageKey());
		accountService.updateAccount(account);

		return "redirect:/company?companyId=" + companyLogin.getId() + "&mode=" + mode;
	}

	@RequestMapping(value = "/company/settingEmail", method = RequestMethod.POST)
	public String settingEmail(@RequestParam("companyId") Integer companyId,
			@RequestParam("mode") String mode,
			@RequestParam("accountId") Integer accountId,
			@RequestParam("newEmail") String newEmail,
			HttpSession session) {

		Account account = getLoggedAccount();
		if (account != null && account.getCompany() != null && account.getCompany().getId() == companyId) {
	
			accountService.updateEmail(accountId, newEmail);
	
			Company companySession = (Company) session.getAttribute("companySession");
	
			if (companySession != null) {
				companySession.getAccount().setEmail(newEmail);
				session.setAttribute("companySession", companySession);
			}
	
			return "redirect:/company?companyId=" + companyId + "&mode=" + mode;
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/company/settingLanguage", method = RequestMethod.POST)
	public String settingLocale(@RequestParam("companyId") Integer companyId,
			@RequestParam("mode") String mode,
			@RequestParam("accountId") Integer accountId,
			@RequestParam("locale") String locale,
			HttpSession session) {

		Account account = getLoggedAccount();
		if (account != null && account.getCompany() != null && account.getCompany().getId() == companyId) {
			accountService.updateLocale(accountId, locale);
	
			Company companySession = (Company) session.getAttribute("companySession");
	
			if (companySession != null) {
				companySession.getAccount().setLocale(locale);
				session.setAttribute("companySession", companySession);
			}
	
			return "redirect:/company?companyId=" + companyId + "&mode=" + mode;
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/company/apply", method = RequestMethod.GET)
	public String goToCompaniesApply(
			@RequestParam("companyId") Integer companyId,
			@RequestParam("jobId") Integer jobId,
			Model model) {

		Account accountLogin = getLoggedAccount();

		if (accountLogin == null || accountLogin.getCompany() == null) {
			return "redirect:/login";
		}

		List<Apply> applies = applyService.findApplies(jobId);
		model.addAttribute("applies", applies);
		model.addAttribute(new MessageDTO());
		
		Company company = companyService.getCompanyById(companyId);
		model.addAttribute("company", company);
		Long numberFollower = followService.countNumberOfFollower(accountLogin.getId());
		model.addAttribute("numberFollower", numberFollower);

		Job job = jobService.getJobById(jobId);
		model.addAttribute("job", job);

		return "company-applies";
	}

	@RequestMapping(value = "/company/subscribe", method = RequestMethod.POST)
	public String settingFollow(@RequestParam("companyId") Integer companyId,
			@RequestParam("mode") String mode,
			@RequestParam("accountId") Integer accountId) {

		Account accountFrom = getLoggedAccount(); // member

		if (accountFrom == null) {
			return "redirect:/login";
		}

		Account accountTo = accountService.getAccountById(accountId); // company

		followService.create(accountFrom, accountTo);

		loggerService.create(accountTo.getId(), accountFrom.getId(), CommonEnum.FOLLOW.getStatus(), false);

		return "redirect:/company?companyId=" + companyId + "&mode=" + mode;
	}

	@RequestMapping(value = "/company/comment/delete", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO deleteComment(@RequestBody CommentDTO commentDTO) {

		CommonResponseDTO response = new CommentResponseDTO();
		if (!commentService.delete(commentDTO.getCommentId())) {
			response.setResult(StatusResponseEnum.FAIL.getStatus());
		}

		response.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return response;
	}

	@RequestMapping(value = "/company/replyComment/delete", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO deleteReplyComment(@RequestBody ReplyCommentDTO replyCommentDTO) {

		CommonResponseDTO response = new CommentResponseDTO();
		if (!replyCommentService.delete(replyCommentDTO.getReplyCommentId())) {
			response.setResult(StatusResponseEnum.FAIL.getStatus());
		}

		response.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return response;
	}

	@RequestMapping(value = "/company/photo/add", method = RequestMethod.POST)
	public String uploadBanner(
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session) {

		Company companyLogin = null;
		Account account = getLoggedAccount();
		if (account != null) {
			companyLogin = account.getCompany();
		} else {
			return "redirect:/login";
		}

		CompanyPhoto companyPhoto = new CompanyPhoto();
		companyPhoto = ImageUtil.convertImageToByte(blobstoreService, request, companyPhoto);
		companyPhoto.setTitle(title);
		companyPhoto.setDescription(description);
		companyPhotoService.createPhotoBanner(companyLogin.getId(), companyPhoto);

		return "redirect:/company?companyId=" + companyLogin.getId() + "&mode=HOME";
	}

	@RequestMapping(value = "/company/photo/delete", method = RequestMethod.POST)
	public String uploadBanner(@RequestParam("photoId") Integer photoId, @RequestParam("photoKey") String photoKey) {

		Company companyLogin = null;
		Account account = getLoggedAccount();
		if (account != null) {
			companyLogin = account.getCompany();
		} else {
			return "redirect:/login";
		}

		companyPhotoService.deletePhotoBanner(photoId);
		BlobKey blobKeyDelete = new BlobKey(photoKey);
		blobstoreService.delete(blobKeyDelete);

		return "redirect:/company?companyId=" + companyLogin.getId() + "&mode=HOME";
	}

	@RequestMapping(value = "/company/apply/export", method = RequestMethod.GET)
	public String exportApplyList(
			@RequestParam("companyId") Integer companyId,
			@RequestParam("jobId") Integer jobId) {

		Account account = getLoggedAccount();
		
		if (account != null && account.getCompany() != null && account.getCompany().getId() == companyId) {
			return "redirect:/export/applyList?companyId=" + companyId + "&jobId=" + jobId;
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/company/job/loadMore", method = RequestMethod.POST)
	public @ResponseBody JobResponseDTO getJobHot(
			@RequestBody LoadMoreRequestDTO loadMoreRequestDTO) {

		Account account = getLoggedAccount();
		boolean isAll = false;
		if (account != null && account.getCompany() != null && account.getCompany().getId() == loadMoreRequestDTO.getCompanyId()) {
			isAll = true;
		}

		JobResponseDTO jobResponseDTO = new JobResponseDTO();

		PagingDTO pgDTO = Utils.calculatorPaging(loadMoreRequestDTO.getPagingDTO(), false);

		List<Job> jobList = companyService.getListJob(pgDTO.getFirstItem(), ConstantValues.MAX_RECORD_COUNT, loadMoreRequestDTO.getCompanyId(), isAll);

		if (Utils.isEmptyList(jobList)) {
			jobResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		}
		jobResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());

		jobResponseDTO.setJobDTOList(jobList);

		Map<Integer, Long> applyNumbers = new HashMap<>();

		for (Job job : jobList) {
			applyNumbers.put(job.getId(), jobService.countApplies(job));
		}

		jobResponseDTO.setApplyNumbers(applyNumbers);

		return jobResponseDTO;
	}
}
