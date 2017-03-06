package vn.com.hiringviet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.com.hiringviet.dto.MessageDTO;
import vn.com.hiringviet.service.ApplyService;
import vn.com.hiringviet.service.MailboxService;
import vn.com.hiringviet.service.MemberService;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageController.
 */
@Controller
@RequestMapping("/api/message")
public class MessageController {
	
	/** The mail box service. */
	@Autowired
	private MailboxService mailBoxService;

	/** The member service. */
	@Autowired
	private MemberService memberService;
	
	/** The apply service. */
	@Autowired
	private ApplyService applyService;

	/**
	 * Send message.
	 *
	 * @param message the message
	 * @return the string
	 */
	@ResponseBody
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public String sendMessage(@ModelAttribute MessageDTO message) {
		mailBoxService.sendMessageViaDto(message);
		return "Send successfully";
	}
}
