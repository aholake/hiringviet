package vn.com.hiringviet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.response.JobResponseDTO;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.dto.PagingDTO;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Skill;
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

	@RequestMapping(value = "/job/hot", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody JobResponseDTO getJobHot(@RequestBody PagingDTO pagingDTO) {

		JobResponseDTO jobResponseDTO = new JobResponseDTO();

		pagingDTO = Utils.calculatorPaging(pagingDTO);

		List<Skill> skills = new ArrayList<Skill>();
		Skill skill = new Skill();
		skill.setId(1);
		skills.add(skill);
		skill.setId(4);
		skills.add(skill);
		List<Job> jobList = jobService.getJobList(pagingDTO.getFirstItem(), ConstantValues.MAX_RECORD_COUNT, true, skills);

		if (Utils.isEmptyList(jobList)) {
			jobResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		}
		jobResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());

		jobResponseDTO.setJobDTOList(jobList);

		return jobResponseDTO;
	}
}
