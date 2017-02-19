package vn.com.hiringviet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.auth.AuthenticationUtil;
import vn.com.hiringviet.common.StatusResponseEnum;
import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.model.Account;
import vn.com.hiringviet.service.ApplyService;
import vn.com.hiringviet.service.MailboxService;
import vn.com.hiringviet.service.MemberService;

@Controller
@RequestMapping("/api/message")
public class MessageController {
	@Autowired
	private MailboxService mailBoxService;

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ApplyService applyService;

	@ResponseBody
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String sendMessage(@ModelAttribute MessageDTO message) {
		mailBoxService.sendMessageViaDto(message);
		return "Send successfully";
	}
}
