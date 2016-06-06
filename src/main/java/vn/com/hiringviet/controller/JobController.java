package vn.com.hiringviet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.response.JobResponseDTO;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.service.JobService;
import vn.com.hiringviet.util.Utils;

@Controller
public class JobController {
	@Autowired
	private JobService jobService;
	
	@RequestMapping(value = "/job/{jobID}", method = RequestMethod.GET)
	public @ResponseBody Job getJob(@PathVariable("jobID") Integer jobID) {

		return jobService.getJobById(jobID);
	}

	@RequestMapping(value = "/job/hot", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JobResponseDTO getJobHot() {

		JobResponseDTO jobResponseDTO = new JobResponseDTO();

		List<Job> jobList = jobService.getJobList(0, 10, true);

		if (Utils.isEmptyList(jobList)) {
			jobResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		}
		jobResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());

		jobResponseDTO.setJobDTOList(jobList);

		return jobResponseDTO;
	}
}
