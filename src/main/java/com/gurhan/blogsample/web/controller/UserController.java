package com.gurhan.blogsample.web.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gurhan.blogsample.persistence.model.User;
import com.gurhan.blogsample.service.PostService;
import com.gurhan.blogsample.service.UserService;
import com.gurhan.blogsample.validation.EmailExistException;
import com.gurhan.blogsample.web.dto.PostDTO;
import com.gurhan.blogsample.web.dto.UserDTO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	PostService postService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String showRegistrationForm(Principal principal, WebRequest request, Model model) {
		if (principal == null) {
			UserDTO user = new UserDTO();
			model.addAttribute("user", user);
			return "registration";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/user/registration", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDTO accountDTO, BindingResult result,
			WebRequest req, Error errors) {
		User registered = null;

		try {
			if (!result.hasErrors()) {
				registered = createUserAccount(accountDTO, result);
			}
			if (registered == null) {
				result.rejectValue("email", "message.regError");
				throw new Exception();
			}
		} catch (Exception e) {
			return new ModelAndView("registration", "user", accountDTO);
		}
		return new ModelAndView("successRegister", "user", accountDTO);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public String getUserById(@PathVariable(value = "userId") Long userId) {
		return "forward:/user/" + userId + "/1";
	}

	@RequestMapping(value = "/user/{userId}/{pageNumber}", method = RequestMethod.GET)
	public String getUserById(@PathVariable(value = "userId") Long userId,
			@PathVariable(value = "pageNumber") int pageNumber, ModelMap model) {
		UserDTO user = userService.findUserById(userId);
		List<PostDTO> userPosts = postService.getPostsByUser(userId, pageNumber);
		model.put("user", user);
		model.put("userPosts", userPosts);
		model.put("currentPage", pageNumber);
		model.put("isLastPage", postService.isLastPageForUserPosts(userId, pageNumber));
		return "userProfile";
	}

	private User createUserAccount(UserDTO accountDTO, BindingResult result) {
		User registered = null;
		try {
			accountDTO.setPassword(passwordEncoder.encode(accountDTO.getPassword()));
			registered = userService.registerNewUserAccount(accountDTO);
		} catch (EmailExistException e) {
			e.printStackTrace();
		}
		return registered;
	}

	@RequestMapping(value = "/user/secure/home")
	public String secureHome() {
		return "secureHome";
	}
}
