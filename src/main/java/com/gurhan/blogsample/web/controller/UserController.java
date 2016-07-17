package com.gurhan.blogsample.web.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gurhan.blogsample.persistence.model.User;
import com.gurhan.blogsample.service.UserService;
import com.gurhan.blogsample.validation.EmailExistException;
import com.gurhan.blogsample.web.dto.UserDTO;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

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

	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
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
