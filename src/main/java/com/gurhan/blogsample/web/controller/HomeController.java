package com.gurhan.blogsample.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gurhan.blogsample.service.PostService;
import com.gurhan.blogsample.web.dto.PostDTO;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/")
	public String home() {
		return "forward:/posts/1";
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
	
	@RequestMapping(value = "/posts/{page}", method = RequestMethod.GET)
	public ModelAndView posts(@PathVariable(value="page") int page){
		if(page < 1 ) {
			return new ModelAndView("/posts/1");
		}
		List<PostDTO> postByPage = postService.getAllPostByPage(page);
		
		return new ModelAndView("/posts", "posts", postByPage);
	}
	

}
