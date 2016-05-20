package vn.com.hiringviet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.api.dto.response.CommonResponseDTO;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.dto.MemberDTO;
import vn.com.hiringviet.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/member/checkAccount", method = RequestMethod.POST)
	public @ResponseBody CommonResponseDTO login(@RequestBody MemberDTO memberDTO) {

		CommonResponseDTO commonResponseDTO = new CommonResponseDTO();
		MemberDTO member = memberService.checkLogin(memberDTO.getEmail(), memberDTO.getPassword());
		if (member == null) {
			commonResponseDTO.setResult(StatusResponseEnum.FAIL.getStatus());
		}
		commonResponseDTO.setResult(StatusResponseEnum.SUCCESS.getStatus());
		return commonResponseDTO;
	}
}
