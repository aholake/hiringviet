package vn.com.hiringviet.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.dto.JobFormDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Skill;
import vn.com.hiringviet.service.CountryService;
import vn.com.hiringviet.service.JobCategoryService;
import vn.com.hiringviet.service.JobService;
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

	@RequestMapping("/job/create")
	public String goToJobCreatePage(Model model) {

		model.addAttribute("newJob", new JobFormDTO());
		model.addAttribute("countries", countryService.getCountryList());
		model.addAttribute("jobCategories", jobCategoryService.getJobCategoryList());
		model.addAttribute("positions", positionService.getPositionList());
		return "job-create";
	}

	@RequestMapping("/rest/job/add")
	public @ResponseBody String addNewJob(@ModelAttribute("newJob") JobFormDTO jobFormDTO) throws ParseException {

		Company company = getLoggedAccount().getCompany();
		if (company == null) {
			return "NOT LOGIN YET";
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
		job.setSkillSet(convertIdListToSkillList(jobFormDTO.getSkillListId()));
		jobService.addJob(job);

		return jobFormDTO.getDescription() + jobFormDTO.getSkillListId();
	}

	private Set<Skill> convertIdListToSkillList(String skillListString) {
		String[] idArr = skillListString.split(",");
		System.out.println(idArr.toString());
		Set<Skill> skills = new HashSet<Skill>();
		for (int i = 0; i < idArr.length; i++) {
			Skill skill = skillService.getSkillById(Integer.parseInt(idArr[i]));
			skills.add(skill);
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