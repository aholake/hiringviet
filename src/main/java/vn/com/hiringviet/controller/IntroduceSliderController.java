package vn.com.hiringviet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroduceSliderController {
	@RequestMapping("/layouts/introduce-slider")
	public String linkIntroduceSlider() {
		return "layouts/introduce-slider";
	}
}
