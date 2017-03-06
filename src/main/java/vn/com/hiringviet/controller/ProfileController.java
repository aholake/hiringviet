package vn.com.hiringviet.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.response.AccountDTO;
import vn.com.hiringviet.api.dto.response.CommentResponseDTO;
import vn.com.hiringviet.api.dto.response.CommonResponseDTO;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.dto.CompanyDTO;
import vn.com.hiringviet.dto.EndorseDTO;
import vn.com.hiringviet.dto.LoggerDTO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.dto.ResumeDTO;
import vn.com.hiringviet.dto.SkillDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Connect;
import vn.com.hiringviet.model.EducationHistory;
import vn.com.hiringviet.model.EmploymentHistory;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.model.Project;
import vn.com.hiringviet.model.Resume;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.ConnectService;
import vn.com.hiringviet.service.EndorseService;
import vn.com.hiringviet.service.FollowService;
import vn.com.hiringviet.service.MemberService;
import vn.com.hiringviet.service.PositionService;
import vn.com.hiringviet.service.ResumeService;
import vn.com.hiringviet.util.ImageUtil;
import vn.com.hiringviet.util.Utils;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileController.
 */
@Controller
public class ProfileController {

	/** The account service. */
	@Autowired
	private AccountService accountService;

	/** The member service. */
	@Autowired
	private MemberService memberService;

	/** The resume service. */
	@Autowired
	private ResumeService resumeService;

	/** The endorse service. */
	@Autowired
	private EndorseService endorseService;

	/** The follow service. */
	@Autowired
	private FollowService followService;

	/** The connect service. */
	@Autowired
	private ConnectService connectService;

	/** The position service. */
	@Autowired
	private PositionService positionService;

	/** The company service. */
	@Autowired
	private CompanyService companyService;

	/** The blobstore service. */
	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

	/**
	 * Go profile banner.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/layouts/profileBanner", method = RequestMethod.GET)
	public String goProfileBanner(Model model, HttpSession session) {

		return "/layouts/profile_banner";
	}

	/**
	 * Go profile header.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/layouts/profileHeader", method = RequestMethod.GET)
	public String goProfileHeader(Model model, HttpSession session) {

		return "/layouts/profile_header";
	}

	/**
	 * Go profile page.
	 *
	 * @param memberId the member id
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String goProfilePage(@RequestParam("memberId") Integer memberId,
			Model model, HttpSession session) {

		Member member = memberService.getMemberByID(memberId);

		Member memberLogin = null;

		Account account = getLoggedAccount();

		if (account != null) {
			memberLogin = account.getMember();
		}

		model.addAttribute("memberLogin", memberLogin);

		boolean checkConnect = false;

		if (Utils.isEmptyObject(memberLogin)) {
			
			checkConnect = true;
		} else {
			
			if (!Utils.isEmptyObject(member)) {
				
				if (memberLogin.getId().compareTo(member.getId()) == 0) {
					
					checkConnect = true;
					
				} else {
					
					Connect connect = connectService.getConnectByMemberId(memberLogin.getId(), member.getId());
					
					if (!Utils.isEmptyObject(connect)) {
						checkConnect = true;
					}
				}
			}
		}

		List<CompanyDTO> follows = companyService.getListCompanyFollow(member.getAccount().getId());
		model.addAttribute("follows", follows);
		model.addAttribute("member", member);
		model.addAttribute("checkConnect", checkConnect);

		model.addAttribute("years", Utils.generatorListYear());
		model.addAttribute("positions", positionService.getPositionList());
		model.addAttribute("educationHistory", new EducationHistory());
		model.addAttribute("employeeHistory", new EmploymentHistory());
		model.addAttribute("project", new Project());
		model.addAttribute("resume", new Resume());
		model.addAttribute("degreeMap", Utils.generatorDegree());
		model.addAttribute("fileUpload", blobstoreService.createUploadUrl("/profile/image"));

		List<LoggerDTO> loggers = accountService.getListLogger(member.getAccount().getId());
		if (loggers != null) {
			model.addAttribute("loggers", loggers);
		}

		return "/profile";
	}

	/**
	 * Adds the skills.
	 *
	 * @param skillDTOs the skill dt os
	 * @return the common response dto
	 */
	@RequestMapping(value = "/profile/addSkills", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO addSkills(@RequestBody Set<SkillDTO> skillDTOs) {

		CommonResponseDTO commonResponseDTO = new CommentResponseDTO();

		Account account = getLoggedAccount();
		if (!memberService.addSkillsOfMember(account, skillDTOs)) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		}
		commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return commonResponseDTO;
	}

	/**
	 * Delete skill of profile.
	 *
	 * @param resumeDTO the resume dto
	 * @return the common response dto
	 */
	@RequestMapping(value = "/profile/deleteSkillOfProfile", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO deleteSkillOfProfile(@RequestBody ResumeDTO resumeDTO) {

		CommonResponseDTO commonResponseDTO = new CommentResponseDTO();

		Account account = getLoggedAccount();

		if (account.getId().equals(resumeDTO.getAccountId())) {
			if (resumeService.deleteSkillOfProfile(resumeDTO)) {
				commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
			}
		}

		commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		return commonResponseDTO;
	}

	/**
	 * Adds the skills.
	 *
	 * @param id the id
	 * @return the member
	 */
	@RequestMapping(value = "/profile/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Member addSkills(@PathVariable("id") Integer id) {
		return memberService.getMemberByID(id);
	}

	/**
	 * Adds the endorse.
	 *
	 * @param skillResumeId the skill resume id
	 * @return the common response dto
	 */
	@RequestMapping(value = "/profile/endorse/add", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO addEndorse(@RequestBody Integer skillResumeId) {

		CommonResponseDTO commonResponseDTO = new CommonResponseDTO();

		Account account = getLoggedAccount();

		if (Utils.isEmptyObject(account)) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return commonResponseDTO;
		}

		EndorseDTO endorseDTO = new EndorseDTO();
		endorseDTO.setSkillResumeId(skillResumeId);
		endorseDTO.setAccount(account);

		if (endorseService.create(endorseDTO) == 0) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return commonResponseDTO;
		}

		commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return commonResponseDTO;
	}

	/**
	 * Removes the endorse.
	 *
	 * @param skillResumeId the skill resume id
	 * @return the common response dto
	 */
	@RequestMapping(value = "/profile/endorse/remove", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO removeEndorse(@RequestBody Integer skillResumeId) {

		CommonResponseDTO commonResponseDTO = new CommonResponseDTO();

		Account account = getLoggedAccount();

		if (Utils.isEmptyObject(account)) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return commonResponseDTO;
		}

		commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());

		if (!endorseService.deleteByAccountId(account.getId(), skillResumeId)) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		}

		return commonResponseDTO;
	}

	/**
	 * Count number of follower.
	 *
	 * @param accountId the account id
	 * @return the member dto
	 */
	@RequestMapping(value = "/profile/countNumberOfFollower", method = RequestMethod.POST)
	public @ResponseBody MemberDTO countNumberOfFollower(@RequestBody Integer accountId) {

		MemberDTO memberDTO = memberService.getMemberByAccountId(accountId);
		if (!Utils.isEmptyObject(memberDTO)) {
			if (followService.countNumberOfFollower(accountId) > 0) {
				memberDTO.setNumberFollower(followService
						.countNumberOfFollower(accountId));
			} else {
				memberDTO.setNumberFollower(0L);
			}
		}

		return memberDTO;
	}

	/**
	 * Creates the education.
	 *
	 * @param model the model
	 * @param educationHistory the education history
	 * @param filterMemberId the filter member id
	 * @return the string
	 */
	@RequestMapping(value = "/profile/createEducation", method = RequestMethod.POST)
	public String createEducation(Model model,
			@ModelAttribute("educationHistory") EducationHistory educationHistory,
			@RequestParam("filterMemberId") String filterMemberId) {

		Member memberLogin = null;
		Account account = getLoggedAccount();
		if (account != null) {
			memberLogin = account.getMember();
		} else {
			return "redirect:/login";
		}

		if (!resumeService.saveEducation(memberLogin.getResume(),
				educationHistory)) {
			model.addAttribute("errorMessage", "");
		}
		return "redirect:/profile?memberId=" + filterMemberId;
	}

	/**
	 * Gets the logged account.
	 *
	 * @return the logged account
	 */
	private Account getLoggedAccount() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof Account) {
			Account loginedAccount = (Account) principal;
			return loginedAccount;
		}
		return null;
	}

	/**
	 * Save summary.
	 *
	 * @param model the model
	 * @param resume the resume
	 * @param filterMemberId the filter member id
	 * @return the string
	 */
	@RequestMapping(value = "/profile/saveSummary", method = RequestMethod.POST)
	public String saveSummary(Model model,
			@ModelAttribute("educationHistory") Resume resume,
			@RequestParam("filterMemberId") String filterMemberId) {

		Member memberLogin = null;
		Account account = getLoggedAccount();
		if (account != null) {
			memberLogin = account.getMember();
		} else {
			return "redirect:/login";
		}

		if (!resumeService.update(memberLogin.getResume(), resume)) {
			model.addAttribute("errorMessage", "");
		}
		return "redirect:/profile?memberId=" + filterMemberId;
	}

	/**
	 * Adds the connect.
	 *
	 * @param toMemberId the to member id
	 * @return the common response dto
	 */
	@RequestMapping(value = "/profile/addConnect", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO addConnect(@RequestBody Integer toMemberId) {

		CommonResponseDTO commonResponseDTO = new CommentResponseDTO();

		Member member = getLoggedAccount().getMember();

		if (Utils.isEmptyObject(member)) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
			return commonResponseDTO;
		}
		memberService.addConnect(member, toMemberId);
		commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return commonResponseDTO;
	}

	/**
	 * Creates the employee.
	 *
	 * @param model the model
	 * @param employeeHistory the employee history
	 * @param filterMemberId the filter member id
	 * @param positionId the position id
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/profile/createEmployee", method = RequestMethod.POST)
	public String createEmployee(
			Model model,
			@ModelAttribute("employeeHistory") EmploymentHistory employeeHistory,
			@RequestParam("filterMemberId") String filterMemberId,
			@RequestParam("positionId") Integer positionId, HttpSession session) {

		Member memberLogin = null;
		Account account = getLoggedAccount();
		if (account != null) {
			memberLogin = account.getMember();
		} else {
			return "redirect:/login";
		}

		if (!resumeService.saveEmployee(memberLogin.getResume(),
				employeeHistory, positionId)) {
			model.addAttribute("errorMessage", "");
		}
		return "redirect:/profile?memberId=" + filterMemberId;
	}

	/**
	 * Upload avatar image.
	 *
	 * @param request the request
	 * @param response the response
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/profile/image", method = RequestMethod.POST)
	public String uploadAvatarImage(
			HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session) {

		Member memberLogin = null;
		Account account = getLoggedAccount();
		if (account != null) {
			memberLogin = account.getMember();
		} else {
			return "redirect:/login";
		}

		AccountDTO accountDTO =  ImageUtil.convertImageToByte(blobstoreService, request, account);
		account.setAvatarImage(accountDTO.getAvatarImage());
		account.setAvatarImageKey(accountDTO.getAvatarImageKey());
		accountService.updateAccount(account);

		return "redirect:/profile?memberId=" + memberLogin.getId();
	}

	/**
	 * Data binding.
	 *
	 * @param binder the binder
	 */
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	/**
	 * Setting phone number.
	 *
	 * @param memberId the member id
	 * @param resumeId the resume id
	 * @param newPhoneNumber the new phone number
	 * @return the string
	 */
	@RequestMapping(value = "/profile/settingPhoneNumber", method = RequestMethod.POST)
	public String settingPhoneNumber(@RequestParam("memberId") Integer memberId,
			@RequestParam("resumeId") Integer resumeId,
			@RequestParam("newPhoneNumber") String newPhoneNumber) {

		resumeService.updatePhoneNumber(resumeId, newPhoneNumber);

		return "redirect:/profile?memberId=" + memberId;
	}

	/**
	 * Setting email.
	 *
	 * @param memberId the member id
	 * @param accountId the account id
	 * @param newEmail the new email
	 * @return the string
	 */
	@RequestMapping(value = "/profile/settingEmail", method = RequestMethod.POST)
	public String settingEmail(@RequestParam("memberId") Integer memberId,
			@RequestParam("accountId") Integer accountId,
			@RequestParam("newEmail") String newEmail) {

		accountService.updateEmail(accountId, newEmail);

		return "redirect:/profile?memberId=" + memberId;
	}

	/**
	 * Setting locale.
	 *
	 * @param memberId the member id
	 * @param accountId the account id
	 * @param locale the locale
	 * @return the string
	 */
	@RequestMapping(value = "/profile/settingLanguage", method = RequestMethod.POST)
	public String settingLocale(@RequestParam("memberId") Integer memberId,
			@RequestParam("accountId") Integer accountId,
			@RequestParam("locale") String locale) {

		accountService.updateLocale(accountId, locale);

		return "redirect:/profile?memberId=" + memberId;
	}

	/**
	 * Export apply list.
	 *
	 * @param memberId the member id
	 * @return the string
	 */
	@RequestMapping(value = "/profile/export", method = RequestMethod.GET)
	public String exportApplyList(
			@RequestParam("memberId") Integer memberId) {

		Account account = getLoggedAccount();

		if (account != null && account.getMember() != null && account.getMember().getId() == memberId) {
			return "redirect:/export/CV?memberId=" + memberId;
		} else {
			return "redirect:/login";
		}
	}
}
