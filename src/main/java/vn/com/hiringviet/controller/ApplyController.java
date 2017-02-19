package vn.com.hiringviet.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.auth.AuthenticationUtil;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.model.Apply;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.model.Message;
import vn.com.hiringviet.service.ApplyService;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

@Controller
public class ApplyController {
	@Autowired
	private ApplyService applyService;

	private BlobstoreService blobStoreService = BlobstoreServiceFactory
			.getBlobstoreService();

	@RequestMapping(value = "/doApply", method = RequestMethod.POST)
	public String doApply(@RequestParam("jobList") String jobList,
			@RequestParam("description") String description,
			HttpServletRequest request) {
		Map<String, List<BlobKey>> blobInfos = blobStoreService
				.getUploads(request);

		BlobKey blobKey = blobInfos.get("curriculumVitae").get(0);
		System.out.println(blobKey.getKeyString());
		Member member = AuthenticationUtil.getLoggedAccount().getMember();
		if (member != null) {
			ApplyDTO applyDto = new ApplyDTO();
			applyDto.setJobList(jobList);
			applyDto.setDescription(description);
			applyDto.setCurriculumVitae(blobKey.getKeyString());
			applyService.addApplyByDTO(applyDto, member);
		}
		return "redirect:/applySuccess";
	}

	@RequestMapping(value = "/applySuccess", method = RequestMethod.GET)
	public String goToApplySuccess() {
		return "apply-success";
	}
	
	@RequestMapping(value = "/file/download/{fileKey}", method = RequestMethod.GET)
	public void downloadCV(@PathVariable("fileKey") String fileKey, HttpServletResponse response) throws IOException {
        BlobKey blobKey = new BlobKey(fileKey);
        blobStoreService.serve(blobKey, response);

	}
	
	@RequestMapping(value = "/apply/sendApprovalMessage", method = RequestMethod.POST)
	public void approveApply(@ModelAttribute MessageDTO messageDTO,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Message message = new Message();
		message.setTitle(messageDTO.getTitle());
		message.setContent(messageDTO.getContent());
		applyService.sendApprovedApplyMessage(messageDTO.getApplyId(), message);

		response.sendRedirect("/company/apply?companyId="
				+ messageDTO.getCompanyId() + "&jobId=" + messageDTO.getJobId());
	}

	@RequestMapping(value = "/apply/sendDeniedMessage", method = RequestMethod.GET)
	public void sendDeniedMessage(@RequestParam("applyId") int applyId, @RequestParam("companyId") int companyId, @RequestParam("jobId") int jobId, HttpServletResponse response) throws IOException {
		applyService.sendDeniedApplyMessage(applyId);
		response.sendRedirect("/company/apply?companyId="
				+ companyId + "&jobId=" + jobId);
	}
}