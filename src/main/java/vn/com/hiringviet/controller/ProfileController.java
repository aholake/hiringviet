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

@Controller
public class ProfileController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private ResumeService resumeService;

	@Autowired
	private EndorseService endorseService;

	@Autowired
	private FollowService followService;

	@Autowired
	private ConnectService connectService;

	@Autowired
	private PositionService positionService;

	@Autowired
	private CompanyService companyService;

	private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

	@RequestMapping(value = "/layouts/profileBanner", method = RequestMethod.GET)
	public String goProfileBanner(Model model, HttpSession session) {

		return "/layouts/profile_banner";
	}

	@RequestMapping(value = "/layouts/profileHeader", method = RequestMethod.GET)
	public String goProfileHeader(Model model, HttpSession session) {

		return "/layouts/profile_header";
	}

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
		return "/profile";
	}

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

	@RequestMapping(value = "/profile/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Member addSkills(@PathVariable("id") Integer id) {
		return memberService.getMemberByID(id);
	}

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

	@RequestMapping(value = "/profile/createEducation", method = RequestMethod.POST)
	public String createEducation(Model model,
			@ModelAttribute("educationHistory") EducationHistory educationHistory,
			@RequestParam("filterMemberId") String filterMemberId) {

		Member memberLogin = null;
		Account account = getLoggedAccount();
		if (account != null) {
			memberLogin = account.getMember();
		}

		if (!resumeService.saveEducation(memberLogin.getResume(),
				educationHistory)) {
			model.addAttribute("errorMessage", "");
		}
		return "redirect:/profile?memberId=" + filterMemberId;
	}

	private Account getLoggedAccount() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof Account) {
			Account loginedAccount = (Account) principal;
			return loginedAccount;
		}
		return null;
	}

	@RequestMapping(value = "/profile/saveSummary", method = RequestMethod.POST)
	public String saveSummary(Model model,
			@ModelAttribute("educationHistory") Resume resume,
			@RequestParam("filterMemberId") String filterMemberId) {

		Member memberLogin = null;
		Account account = getLoggedAccount();
		if (account != null) {
			memberLogin = account.getMember();
		}

		if (!resumeService.update(memberLogin.getResume(), resume)) {
			model.addAttribute("errorMessage", "");
		}
		return "redirect:/profile?memberId=" + filterMemberId;
	}

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
		}

		if (!resumeService.saveEmployee(memberLogin.getResume(),
				employeeHistory, positionId)) {
			model.addAttribute("errorMessage", "");
		}
		return "redirect:/profile?memberId=" + filterMemberId;
	}

	@RequestMapping(value = "/profile/image", method = RequestMethod.POST)
	public String uploadAvatarImage(
			HttpServletRequest request, 
			HttpServletResponse response,
			HttpSession session) {

		Member memberLogin = null;
		Account account = getLoggedAccount();
		if (account != null) {
			memberLogin = account.getMember();
		}

		AccountDTO accountDTO =  ImageUtil.convertImageToByte(blobstoreService, request, account);
		account.setAvatarImage(accountDTO.getAvatarImage());
		account.setAvatarImageKey(accountDTO.getAvatarImageKey());
		accountService.updateAccount(account);

		return "redirect:/profile?memberId=" + memberLogin.getId();
	}

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping(value = "/profile/settingPhoneNumber", method = RequestMethod.POST)
	public String settingPhoneNumber(@RequestParam("memberId") Integer memberId,
			@RequestParam("resumeId") Integer resumeId,
			@RequestParam("newPhoneNumber") String newPhoneNumber) {

		resumeService.updatePhoneNumber(resumeId, newPhoneNumber);

		return "redirect:/profile?memberId=" + memberId;
	}

	@RequestMapping(value = "/profile/settingEmail", method = RequestMethod.POST)
	public String settingEmail(@RequestParam("memberId") Integer memberId,
			@RequestParam("accountId") Integer accountId,
			@RequestParam("newEmail") String newEmail) {

		accountService.updateEmail(accountId, newEmail);

		return "redirect:/profile?memberId=" + memberId;
	}

	@RequestMapping(value = "/profile/settingLanguage", method = RequestMethod.POST)
	public String settingLocale(@RequestParam("memberId") Integer memberId,
			@RequestParam("accountId") Integer accountId,
			@RequestParam("locale") String locale) {

		accountService.updateLocale(accountId, locale);

		return "redirect:/profile?memberId=" + memberId;
	}
}
