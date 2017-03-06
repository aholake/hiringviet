package vn.com.hiringviet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.common.StatusEnum;
import vn.com.hiringviet.dto.CompanyAdminTableDTO;
import vn.com.hiringviet.dto.MemberAdminTableDTO;
import vn.com.hiringviet.model.Company;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.CompanyService;
import vn.com.hiringviet.service.MemberService;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminController.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	/** The member service. */
	@Autowired
	private MemberService memberService;

	/** The company service. */
	@Autowired
	private CompanyService companyService;

	/**
	 * Go home page.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping({ "", "/" })
	public String goHomePage(Model model, HttpSession session) {
		return "/admin/index";
	}

	/**
	 * Go member management page.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping({ "/account" })
	public String goMemberManagementPage(Model model, HttpSession session) {
		return "/admin/account-management";
	}

	/**
	 * Go company management page.
	 *
	 * @param model the model
	 * @param session the session
	 * @return the string
	 */
	@RequestMapping({ "/company" })
	public String goCompanyManagementPage(Model model, HttpSession session) {
		return "/admin/company-management";
	}

	/**
	 * Gets the member table dto list.
	 *
	 * @return the member table dto list
	 */
	@RequestMapping(value = "/api/members", method = RequestMethod.GET)
	@ResponseBody
	public List<MemberAdminTableDTO> getMemberTableDTOList() {
		return memberService.getListMemberForAdminPage();
	}

	/**
	 * Delete member from datatable.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@RequestMapping(value = "/api/members", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteMemberFromDatatable(@RequestBody int id) {
		Member member = memberService.getMemberByID(id);
		member.getAccount().setStatus(StatusEnum.DELETE);
		return memberService.updateMember(member);
	}

	/**
	 * Gets the all company admin dto.
	 *
	 * @return the all company admin dto
	 */
	@RequestMapping(value = "/api/companies", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanyAdminTableDTO> getAllCompanyAdminDTO() {
		return companyService.getAllCompaniesForAdminTable();
	}

	/**
	 * Delete company from data table.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@RequestMapping(value = "/api/companies", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteCompanyFromDataTable(@RequestBody int id) {
		Company company = companyService.getCompanyById(id);
		company.getAccount().setStatus(StatusEnum.DELETE);
		return companyService.updateCompany(company);
	}
	
	/**
	 * Go to message page.
	 *
	 * @return the string
	 */
	@RequestMapping("/inbox")
	public String goToMessagePage() {
		return "/admin/inbox";
	}
	
	/**
	 * Go to job page.
	 *
	 * @return the string
	 */
	@RequestMapping("/job")
	public String goToJobPage() {
		return "/admin/job-management";
	}
}
