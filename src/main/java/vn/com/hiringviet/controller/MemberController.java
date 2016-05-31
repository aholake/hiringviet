//package vn.com.hiringviet.controller;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import vn.com.hiringviet.api.dto.response.CommonResponseDTO;
//import vn.com.hiringviet.common.StatusResponseEnum;
//import vn.com.hiringviet.dto.MemberDTO;
//import vn.com.hiringviet.service.MemberService;
//import vn.com.hiringviet.util.CookieUtil;
//
//@Controller
//public class MemberController {
//
//	@Autowired
//	private MemberService memberService;
//
//	@RequestMapping(value = "/member/checkAccount", method = RequestMethod.POST)
//	public @ResponseBody CommonResponseDTO login(@RequestBody MemberDTO memberDTO, HttpServletResponse response, HttpSession session) {
//
//		CommonResponseDTO commonResponseDTO = new CommonResponseDTO();
//		MemberDTO member = memberService.checkLogin(memberDTO.getEmail(), memberDTO.getPassword());
//		if (member == null) {
//			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
//			return commonResponseDTO;
//		}
//
//		if (memberDTO.isRemembered()) {
//			CookieUtil.createCookie(response, "email", member.getEmail());
//			CookieUtil.createCookie(response, "password", member.getPassword());
//			System.out.println("Cookies is saved");
//		}
//
//		session.setAttribute("memberDTO", member);
//		commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
//		return commonResponseDTO;
//	}
//}
