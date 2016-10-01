package vn.com.hiringviet.controller;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import vn.com.hiringviet.binder.DateBinder;

@ControllerAdvice
public class CommonController {
	@InitBinder
	public void binder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateBinder());
	}
}
