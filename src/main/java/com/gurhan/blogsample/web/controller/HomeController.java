package com.gurhan.blogsample.web.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gurhan.blogsample.service.PostService;
import com.gurhan.blogsample.service.UserService;
import com.gurhan.blogsample.util.ControllerUtil;
import com.gurhan.blogsample.web.dto.PostDTO;
import com.gurhan.blogsample.web.dto.UserDTO;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;

	@Autowired
	private UserService userService;

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
		return "forward:/posts/1";
	}

	@RequestMapping(value = "/posts/{page}", method = RequestMethod.GET)
	public String posts(@PathVariable(value = "page") int page, ModelMap model) {
		if (page < 1) {
			return "/posts/1";
		}
		List<PostDTO> postByPage = postService.getAllPostByPage(page);
		model.put("posts", postByPage);
		model.put("currentPage", page);
		model.put("isLastPage", postService.isLastPage(page));
		return "/posts";
	}

	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public String postById(@PathVariable("id") Long id, ModelMap model, Principal principal) {
		PostDTO postById = postService.getPostById(id);
		String userName = ControllerUtil.getActiveUserName(principal);
		model.put("post", postById);
		model.put("isOwnUser", postById.getUser().getEmail().equals(userName));
		return "post";
	}

	@RequestMapping(value = "/secure/createPost", method = RequestMethod.GET)
	public String createPost(ModelMap model) {
		model.put("post", new PostDTO());
		return "create-post";
	}

	@RequestMapping(value = "/secure/createPost", method = RequestMethod.POST)
	public String createPost(@ModelAttribute(value = "post") PostDTO post, Principal principal) {
		String userName = ControllerUtil.getActiveUserName(principal);
		UserDTO user = userService.findByUserName(userName);
		post.setUser(user);
		post.setDate(new Date());
		postService.createPost(post);
		return String.format("redirect:/user/%d/%d", user.getId(), 1);
	}

	@RequestMapping(value = "/secure/updatePost", method = RequestMethod.POST)
	public String updatePost(@ModelAttribute(value = "post") PostDTO post) {
		PostDTO oldPost = postService.getPostById(post.getId());
		oldPost.setTitle(post.getTitle());
		oldPost.setText(post.getText());
		postService.updatePost(oldPost);
		return "redirect:/post/" + post.getId();
	}

}
