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

import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Country;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.AccountService;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.CountryService;
import vn.com.hiringviet.service.MemberService;

// TODO: Auto-generated Javadoc
/**
 * The Class SignupController.
 */
@Controller
public class SignupController {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger
			.getLogger(SignupController.class);
	
	/** The account service. */
	@Autowired
	private AccountService accountService;

	/** The member service. */
	@Autowired
	private MemberService memberService;

	/** The company service. */
	@Autowired
	private CompanyService companyService;

	/** The country service. */
	@Autowired
	private CountryService countryService;

	/**
	 * Go to register option.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/register")
	public String goToRegisterOption() {
		return "register-option";
	}

	/**
	 * Data binding.
	 *
	 * @param binder the binder
	 */
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	/**
	 * Go to register page.
	 *
	 * @param type the type
	 * @param model the model
	 * @return the model and view
	 */
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

	/**
	 * Check existed email.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	@RequestMapping(value = "/rest/checkExistedEmail", method = RequestMethod.POST)
	public @ResponseBody boolean checkExistedEmail(@RequestBody String email) {
		return accountService.isExistedAccount(email);
	}

	/**
	 * Adds the new member.
	 *
	 * @param member the member
	 * @return the string
	 * @throws Exception the exception
	 */
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

	/**
	 * Adds the new company.
	 *
	 * @param company the company
	 * @return the string
	 * @throws Exception the exception
	 */
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

	/**
	 * Active account.
	 *
	 * @param code the code
	 * @param model the model
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping("/active/{code}")
	public String activeAccount(@PathVariable("code") String code, Model model)
			throws Exception {
		try {
			Account account = accountService.getAccountByActiveCode(code);
			model.addAttribute("email", account.getEmail());
			accountService.activeAccount(code);
			return "active-success";
		} catch (Exception e) {
			LOGGER.error(e);
			throw new Exception();
		}
	}

	/**
	 * Go to sign up success page.
	 *
	 * @return the string
	 */
	@RequestMapping("/signup-success")
	public String goToSignUpSuccessPage() {
		return "signup-success";
	}

}
