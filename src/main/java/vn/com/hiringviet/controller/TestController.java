package vn.com.hiringviet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping(value = "/")
	public @ResponseBody String printString() {
		return "<h1>Hello World</h1><h3>HiringViet</h3>";
	}
}
