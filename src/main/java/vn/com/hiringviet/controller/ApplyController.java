package vn.com.hiringviet.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
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
	
	@RequestMapping(value = "/file/download", method = RequestMethod.GET)
	public void downloadCV(HttpServletResponse response) throws IOException {
		File file = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		file = new File(classLoader.getResource("downloadFile.txt").getFile());

		String mimeType = URLConnection
				.guessContentTypeFromName(file.getName());
		
		if (mimeType == null) {
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}
		
		System.out.println("mimetype : "+mimeType);
        
        response.setContentType(mimeType);
         
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));
 
         
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
         
        response.setContentLength((int)file.length());
 
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
 
        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());

	}
}