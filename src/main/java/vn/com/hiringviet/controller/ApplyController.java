package vn.com.hiringviet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.hiringviet.auth.AuthenticationUtil;
import vn.com.hiringviet.dto.ApplyDTO;
import vn.com.hiringviet.model.Member;
import vn.com.hiringviet.service.ApplyService;

@Controller
public class ApplyController {
	@Autowired
	private ApplyService applyService;
	
	@RequestMapping("/doApply")
	public String doApply(@ModelAttribute ApplyDTO applyDto) {
		Member member = AuthenticationUtil.getLoggedAccount().getMember();
		if (member != null) {
			applyService.addApplyByDTO(applyDto, member);
		}
		return "apply-success";
	}
}
