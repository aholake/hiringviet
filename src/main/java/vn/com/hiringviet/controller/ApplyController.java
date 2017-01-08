package vn.com.hiringviet.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.hiringviet.auth.AuthenticationUtil;
import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.model.Member;
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
}
