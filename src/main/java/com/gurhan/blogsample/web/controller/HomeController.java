package com.gurhan.blogsample.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/user/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login_error")
	public String loginError() {
		return "loginError";
	}


}
