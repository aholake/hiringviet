package vn.com.hiringviet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.service.JobService;

@Controller
public class JobController {
	@Autowired
	private JobService jobService;
	
	@RequestMapping(value = "/job/{jobID}", method = RequestMethod.GET)
	public @ResponseBody JobDTO getJob(@PathVariable("jobID") Integer jobID) {
		System.out.println(jobService.getJobByID(jobID));
		return jobService.getJobByID(jobID);
	}

	@RequestMapping(value = "/job/hot", method = RequestMethod.GET)
	public @ResponseBody List<JobDTO> getJobHot() {
		return jobService.getListJobHot(0, 10);
	}
}
