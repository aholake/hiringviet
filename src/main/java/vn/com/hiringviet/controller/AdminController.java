package vn.com.hiringviet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.dto.MemberAdminTableDTO;
import vn.com.hiringviet.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/")
	public String goHomePage(Model model, HttpSession session) {
		return "/admin/home";
	}
	
	@RequestMapping(value="/members", method=RequestMethod.GET)
	@ResponseBody
	public List<MemberAdminTableDTO> getMemberTableDTOList() {
		return memberService.getListMemberForAdminPage();
	}
	
}
