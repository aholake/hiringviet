package vn.com.hiringviet.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Country;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.CountryService;
import vn.com.hiringviet.service.MemberService;

@Controller
public class SignupController {
	private static final Logger LOGGER = Logger
			.getLogger(SignupController.class);
	@Autowired
	private AccountService accountService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CountryService countryService;

	@RequestMapping(value = "/register")
	public String goToRegisterOption() {
		return "register-option";
	}

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping(value = "/register/{type}")
	public ModelAndView goToRegisterPage(@PathVariable("type") String type,
			Model model) {
		if (type.equals("company")) {
			List<Country> countries = countryService.getCountryList();
			model.addAttribute("countries", countries);
			return new ModelAndView("company-register", "newCompany",
					new Company());
		}
		if (type.equals("member")) {
			return new ModelAndView("member-register", "newMember",
					new Member());
		}
		return null;
	}

	@RequestMapping(value = "/rest/saveMember", method = RequestMethod.POST)
	public @ResponseBody String saveNewMember(
			@ModelAttribute("newMember") Member member) {
		LOGGER.info("Save a new member");
		LOGGER.info(member.getBirthDate());
		if (memberService.addMember(member) > 0) {
			return "Added successfully";

		}
		return "Add failed";
	}

	@RequestMapping(value = "/rest/checkExistedEmail", method = RequestMethod.POST)
	public @ResponseBody boolean checkExistedEmail(@RequestBody String email) {
		return accountService.isExistedAccount(email);
	}

	@RequestMapping(value = "/rest/addNewMember", method = RequestMethod.POST)
	public String addNewMember(@ModelAttribute("newMember") Member member)
			throws Exception {
		int id = memberService.addMember(member);
		if (id > 0) {
			return "redirect:/signup-success";
		} else {
			throw new Exception();
		}
	}

	@RequestMapping(value = "/rest/addNewCompany")
	public String addNewCompany(@ModelAttribute("newCompany") Company company)
			throws Exception {
		int id = companyService.addCompany(company);
		if (id > 0) {
			return "redirect:/signup-success";
		} else {
			throw new Exception();
		}
	}

	@RequestMapping("/active/{code}")
	public @ResponseBody StatusResponseEnum activeAccount(
			@PathVariable("code") String code) {
		try {
			accountService.activeAccount(code);
			return StatusResponseEnum.SUCCESS;
		} catch (Exception e) {
			LOGGER.error(e);
			return StatusResponseEnum.FAIL;
		}
	}

	@RequestMapping("/signup-success")
	public String goToSignUpSuccessPage() {
		return "signup-success";
	}

}
