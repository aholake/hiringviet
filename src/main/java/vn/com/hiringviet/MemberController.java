package vn.com.hiringviet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/")
	public String helloWorld() {
		return "home";
	}
	
	@RequestMapping(value = "/getMemberList")
	public @ResponseBody List<Member> getListUser() {
		return memberService.getMemberList();
	}
}
