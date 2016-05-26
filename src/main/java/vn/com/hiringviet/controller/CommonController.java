package vn.com.hiringviet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.hiringviet.common.PagingEnum;
import vn.com.hiringviet.dto.JobDTO;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.service.CountryService;
import vn.com.hiringviet.service.JobService;
import vn.com.hiringviet.util.Utils;

@Controller
public class CommonController {

	@Autowired
	private CountryService countryService;

	@Autowired
	private JobService jobService;

	@RequestMapping(value = {"/","/home"})
	public String home(Model model, HttpSession session) {

		MemberDTO memberDTO = Utils.getMemberSession(session);

		if (!Utils.isEmptyObject(memberDTO)) {
			setModelAttribute(model, session);
			return "home_login";
		}
		setModelAttribute(model, session);
		return "home";
	}

	public void setModelAttribute(Model model, HttpSession session) {

		List<JobDTO> jobDTOList = null;
		MemberDTO memberDTO = Utils.getMemberSession(session);

		if (!Utils.isEmptyObject(memberDTO)) {
			jobDTOList = jobService.getListJobHot(PagingEnum.FIRST.getValue(), PagingEnum.MAX.getValue());
		}
		jobDTOList = jobService.getListJobHot(PagingEnum.FIRST.getValue(), PagingEnum.MAX.getValue());

		model.addAttribute("jobDTOList", jobDTOList);
	}

	@RequestMapping("/login")
	public String loginPage() {
		return "login_page";
	}
	
	@RequestMapping(value = "/layouts/navbar")
	public String navbar() {
		return "layouts/navbar";
	}
	
	@RequestMapping(value = "/layouts/footer")
	public String footer() {
		return "layouts/footer";
	}
}
