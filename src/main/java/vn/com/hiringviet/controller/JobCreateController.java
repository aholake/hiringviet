package vn.com.hiringviet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobCreateController {
	@RequestMapping("/job/create")
	public String goToJobCreatePage() {
		return "job-create";
	}
}