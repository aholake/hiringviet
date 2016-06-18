package vn.com.hiringviet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.constant.ConstantValues;
import vn.com.hiringviet.model.Comment;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Job;
import vn.com.hiringviet.model.Post;
import vn.com.hiringviet.service.CommentService;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.FollowService;

/**
 * The Class CompanyController.
 */
@Controller
public class CompanyController {

	/** The company service. */
	@Autowired
	private CompanyService companyService;

	/** The follow service. */
	@Autowired
	private FollowService followService;

	@Autowired
	private CommentService commentService;

	/**
	 * Go company page.
	 *
	 * @param companyId the company id
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/company/{companyId}", method = RequestMethod.GET)
	public String goCompanyPage(@PathVariable("companyId") Integer companyId, Model model, HttpSession session) {

		Company company = companyService.findOne(companyId);
		List<Post> postsList = companyService.getListPosts(0, ConstantValues.MAX_RECORD_COUNT, companyId);
		Long numberFollower = followService.countNumberOfFollower(company.getAccount().getId());

		if (ConstantValues.MAX_RECORD_COUNT > postsList.size()) {
			model.addAttribute("isDisabledLoadPosts", true);
		}

		model.addAttribute("postsList", postsList);
		model.addAttribute("company", company);
		model.addAttribute("numberFollower", numberFollower);
		return "company";
	}

	/**
	 * Go company carrers page.
	 *
	 * @param companyId the company id
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/company/{companyId}/job", method = RequestMethod.GET)
	public String goCompanyCarrersPage(@PathVariable("companyId") Integer companyId, Model model, HttpSession session) {

		Company company = companyService.findOne(companyId);
		List<Job> jobList = companyService.getListJob(0, ConstantValues.MAX_RECORD_COUNT, companyId);

		if (ConstantValues.MAX_RECORD_COUNT > jobList.size()) {
			model.addAttribute("isDisabledLoadJob", true);
		}

		model.addAttribute("jobList", jobList);
		model.addAttribute("company", company);
		return "company-careers";
	}

	/**
	 * Go company banner.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/layouts/companyBanner", method = RequestMethod.GET)
	public String goCompanyBanner(Model model, HttpSession session) {

		return "/layouts/company_banner";
	}

	/**
	 * Go company header.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/layouts/companyHeader", method = RequestMethod.GET)
	public String goCompanyHeader(Model model, HttpSession session) {

		return "/layouts/company_header";
	}

	/**
	 * Go job detail page.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping(value = "/company/careers/{id}", method = RequestMethod.GET)
	public String goJobDetailPage(Model model, HttpSession session) {

		return "job-detail";
	}

	@RequestMapping(value = "/company/post/{postId}/comments", method = RequestMethod.GET)
	public @ResponseBody List<Comment> goJobDetailPage(@PathVariable("postId") Integer postId, Model model, HttpSession session) {

		return commentService.getListCommentByPostId(postId);
	}
}
