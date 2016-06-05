package vn.com.hiringviet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FooterController {
	@RequestMapping(value = "/layouts/footer")
	public String footer() {
		return "layouts/footer";
	}
}
