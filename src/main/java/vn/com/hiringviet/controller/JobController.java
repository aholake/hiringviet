package vn.com.hiringviet.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.request.LoadMoreRequestDTO;
import vn.com.hiringviet.api.dto.response.CommentResponseDTO;
import vn.com.hiringviet.api.dto.response.CommonResponseDTO;
import vn.com.hiringviet.api.dto.response.JobResponseDTO;
import vn.com.hiringviet.auth.AuthenticationUtil;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.dto.JobAdminTableDTO;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.dto.PagingDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.FollowService;
import vn.com.hiringviet.service.JobService;
import vn.com.hiringviet.service.ResumeService;
import vn.com.hiringviet.util.Utils;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class JobController.
 */
@Controller
public class JobController {

	/** The job service. */
	@Autowired
	private JobService jobService;

	@Autowired
	private FollowService followService;

	@Autowired
	private ResumeService resumeService;

	private BlobstoreService blobStoreService = BlobstoreServiceFactory.getBlobstoreService();

	@RequestMapping(value = "/admin/api/jobs", method = RequestMethod.GET)
	public @ResponseBody List<JobAdminTableDTO> getAllJobs() {
		return jobService.getJobsForAdminTable();
	}

	/**
	 * Gets the job.
	 *
	 * @param jobID
	 *            the job id
	 * @return the job
	 */
	@RequestMapping(value = "/job/{jobID}", method = RequestMethod.GET)
	public @ResponseBody Job getJob(@PathVariable("jobID") Integer jobID) {

		return jobService.getJobById(jobID);
	}

	/**
	 * Gets the job hot.
	 *
	 * @param pagingDTO
	 *            the paging dto
	 * @return the job hot
	 */
	@RequestMapping(value = "/job/hot", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JobResponseDTO getJobHot(
			@RequestBody LoadMoreRequestDTO loadMoreRequestDTO) {

		JobResponseDTO jobResponseDTO = new JobResponseDTO();

		PagingDTO pagingDTO = Utils.calculatorPaging(
				loadMoreRequestDTO.getPagingDTO(), false);

		List<Job> jobList = jobService.getJobList(loadMoreRequestDTO,
				pagingDTO.getFirstItem(), ConstantValues.MAX_RECORD_COUNT,
				true, null, null, null);

		if (Utils.isEmptyList(jobList)) {
			jobResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		}
		jobResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());

		jobResponseDTO.setJobDTOList(jobList);

		return jobResponseDTO;
	}

	@RequestMapping(value = "/job/suggest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JobResponseDTO getJobSuggest(
			@RequestBody LoadMoreRequestDTO loadMoreRequestDTO) {

		JobResponseDTO jobResponseDTO = new JobResponseDTO();

		PagingDTO pagingDTO = Utils.calculatorPaging(
				loadMoreRequestDTO.getPagingDTO(), false);

		Account account = AuthenticationUtil.getLoggedAccount();
		Member member = account.getMember();
		List<Integer> skillIds = resumeService.getListSkillByMemberId(member
				.getId());

		List<Job> jobList = jobService.getJobList(loadMoreRequestDTO,
				pagingDTO.getFirstItem(), ConstantValues.MAX_RECORD_COUNT,
				false, skillIds, null, null);

		if (Utils.isEmptyList(jobList)) {
			jobResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		}
		jobResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());

		jobResponseDTO.setJobDTOList(jobList);

		return jobResponseDTO;
	}

	/**
	 * Go job detail page.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	// @RequestMapping(value = "/company/careers", method = RequestMethod.GET)
	// public String goJobDetailPage(@RequestParam("jobId") Integer jobId,
	// Model model, HttpSession session) {
	//
	// Job job = jobService.getJobById(jobId);
	// Long numberFollower =
	// followService.countNumberOfFollower(job.getCompany().getAccount().getId());
	// model.addAttribute("job", job);
	// model.addAttribute("numberFollower", numberFollower);
	// return "job-detail";
	// }

	@RequestMapping(value = "/job/apply", method = RequestMethod.POST)
	public String goApplyPage(@RequestParam("jobList") String jobList,
			Model model) {
		String[] jobIds = jobList.split("\\+");
		System.out.println("JOB ID: " + Arrays.toString(jobIds));
		ApplyDTO applyDTO = new ApplyDTO();
		applyDTO.setJobList(jobList);
		model.addAttribute("applyDTO", applyDTO);
		model.addAttribute("applyFormURL", blobStoreService.createUploadUrl("/doApply"));
		return "apply";
	}

	@RequestMapping(value = "/job/settingDescription", method = RequestMethod.POST)
	public String settingDescription(@RequestParam("jobId") Integer jobId,
			@RequestParam("description") String description) {
		
		jobService.updateDescription(jobId, description);

		return "redirect:/company/careers?jobId=" + jobId;
	}

	@RequestMapping(value = "/job/settingRequirement", method = RequestMethod.POST)
	public String settingRequirement(@RequestParam("jobId") Integer jobId,
			@RequestParam("requirement") String requirement) {
		
		jobService.updateRequirement(jobId, requirement);

		return "redirect:/company/careers?jobId=" + jobId;
	}

	@RequestMapping(value = "/job/settingCompanyPolicies", method = RequestMethod.POST)
	public String settingCompanyPolicies(@RequestParam("jobId") Integer jobId,
			@RequestParam("companyPolicies") String cultureDescription) {

		jobService.updateCompanyPolicies(jobId, cultureDescription);

		return "redirect:/company/careers?jobId=" + jobId;
	}

	@RequestMapping(value = "/job/settingPublish", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO settingPublish(@RequestBody JobDTO jobDTO) {

		CommonResponseDTO response = new CommentResponseDTO();
		if (!jobService.setPublish(jobDTO.getJobId(), jobDTO.getIsPublish())) {
			response.setResult(StatusResponseEnum.FAIL.getStatus());
		}

		response.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return response;
	}
}
