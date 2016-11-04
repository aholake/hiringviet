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

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private MemberService memberService;

	@Autowired
	private CompanyService companyService;

	@RequestMapping({ "", "/" })
	public String goHomePage(Model model, HttpSession session) {
		return "/admin/index";
	}

	@RequestMapping({ "/member" })
	public String goMemberManagementPage(Model model, HttpSession session) {
		return "/admin/member-management";
	}

	@RequestMapping({ "/company" })
	public String goCompanyManagementPage(Model model, HttpSession session) {
		return "/admin/company-management";
	}

	@RequestMapping(value = "/api/members", method = RequestMethod.GET)
	@ResponseBody
	public List<MemberAdminTableDTO> getMemberTableDTOList() {
		return memberService.getListMemberForAdminPage();
	}

	@RequestMapping(value = "/api/members", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteMemberFromDatatable(@RequestBody int id) {
		Member member = memberService.getMemberByID(id);
		member.getAccount().setStatus(StatusEnum.DELETE);
		return memberService.updateMember(member);
	}

	@RequestMapping(value = "/api/companies", method = RequestMethod.GET)
	@ResponseBody
	public List<CompanyAdminTableDTO> getAllCompanyAdminDTO() {
		return companyService.getAllCompaniesForAdminTable();
	}

	@RequestMapping(value = "/api/companies", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteCompanyFromDataTable(@RequestBody int id) {
		Company company = companyService.getCompanyById(id);
		company.getAccount().setStatus(StatusEnum.DELETE);
		return companyService.updateCompany(company);
	}
	
	@RequestMapping("/message")
	public String goToMessagePage() {
		return "/admin/message-box";
	}
}
