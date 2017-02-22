package vn.com.hiringviet.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.hiringviet.dto.JobFormDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Follow;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.service.CountryService;
import vn.com.hiringviet.service.JobCategoryService;
import vn.com.hiringviet.service.JobService;
import vn.com.hiringviet.service.LoggerService;
import vn.com.hiringviet.service.PositionService;
import vn.com.hiringviet.service.SkillService;
import vn.com.hiringviet.util.Utils;

@Controller
public class JobCreateController {
	@Autowired
	private JobService jobService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private PositionService positionService;

	@Autowired
	private SkillService skillService;

	@Autowired
	private JobCategoryService jobCategoryService;

	@Autowired
	private LoggerService loggerService;

	@RequestMapping("/job/create")
	public String goToJobCreatePage(Model model) {

		model.addAttribute("newJob", new JobFormDTO());
		model.addAttribute("countries", countryService.getCountryList());
		model.addAttribute("jobCategories", jobCategoryService.getJobCategoryList());
		model.addAttribute("positions", positionService.getPositionList());
		return "job-create";
	}

	@RequestMapping("/rest/job/add")
	public String addNewJob(@ModelAttribute("newJob") JobFormDTO jobFormDTO) throws ParseException {

		Company company = getLoggedAccount().getCompany();
		if (company == null) {
			return "redirect:/home";
		}

		Job job = new Job();
		job.setCompany(company);
		job.setTitle(jobFormDTO.getTitle());
		job.setJobCategory(jobFormDTO.getJobCategory());
		job.setDescription(jobFormDTO.getDescription());
		job.setRequirement(jobFormDTO.getRequirement());
		job.setPostDate(new Date());
		job.setChangeLog(Utils.createDefaultChangeLog());
		job.setMinSalary(jobFormDTO.getMinSalary());
		job.setMaxSalary(jobFormDTO.getMaxSalary());
		job.setSize(jobFormDTO.getSize());
		job.setWorkAddress(jobFormDTO.getWorkAddress());
		job.setExpiredDate(jobFormDTO.getExpiredDate());
//		job.setSkillSet(convertIdListToSkillList(jobFormDTO.getSkillListId()));
		job.setPosition(positionService.findOne(jobFormDTO.getPosition().getPositionID()));
		job.setNumberVisited(0);
		Integer jobId = jobService.addJob(job);

		if (jobFormDTO.getSkillListId().length() > 2) {
			jobService.insertJobSkill(jobId, convertIdListToSkillList(jobFormDTO.getSkillListId()));
		}
		
		Set<Follow> follows = company.getAccount().getToFollows();
		for (Follow follow : follows) {
			loggerService.jobActivity(company.getAccount(), 
					follow.getFromAccount(), 
					company.getAccount().getAvatarImage(), 
					Utils.genLogFollow(company, job, true), true);
		}
		return "redirect:/company?companyId=" + company.getId() + "&mode=CAREER";
	}

	private List<String> convertIdListToSkillList(String skillListString) {
		String[] idArr = skillListString.split(",");
//		System.out.println(idArr.toString());
		List<String> skills = new ArrayList<String>();
		for (int i = 0; i < idArr.length; i++) {
			skills.add(idArr[i]);
		}
		return skills;
	}

	private Account getLoggedAccount() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof Account) {
			Account loginedAccount = (Account) principal;
			return loginedAccount;
		}
		return null;
	}
}