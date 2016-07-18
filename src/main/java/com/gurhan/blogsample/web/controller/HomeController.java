package com.gurhan.blogsample.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String home() {
		return "posts";
	}

	@RequestMapping(value = "/user/login")
	public String login(Principal principal) {
		if (principal == null) {
			return "login";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/login_error")
	public String loginError() {
		return "loginError";
	}

	@RequestMapping(value = "/index")
	public String ss() {
		return "posts";
	}

}
