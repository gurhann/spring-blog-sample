package com.gurhan.blogsample.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gurhan.blogsample.constant.Role;
import com.gurhan.blogsample.persistence.dao.AuthoritiesDAO;
import com.gurhan.blogsample.persistence.dao.UserDAO;
import com.gurhan.blogsample.persistence.model.Authorities;
import com.gurhan.blogsample.persistence.model.User;
import com.gurhan.blogsample.service.UserService;
import com.gurhan.blogsample.validation.EmailExistException;
import com.gurhan.blogsample.web.dto.UserDTO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AuthoritiesDAO authoritiesDAO;


	@Override
	public User registerNewUserAccount(UserDTO accountDTO) throws EmailExistException {
		if (emailExist(accountDTO.getEmail())) {
			throw new EmailExistException("There is an account with that email address:" + accountDTO.getEmail());
		}
		User user = new User();
		user.setEmail(accountDTO.getEmail());
		user.setFirtName(accountDTO.getFirstName());
		user.setLastName(accountDTO.getLastName());
		user.setPassword(accountDTO.getPassword());
		user.setEnabled(true);
		
		Authorities authority = new Authorities(user.getEmail(), Role.ROLE_USER.getRole());
		userDAO.create(user);
		authoritiesDAO.create(authority);
		return userDAO.findByEmail(user.getEmail());
	}


	@Override
	public void saveRegisteredUser(User user) {
		userDAO.create(user);
	}

	private boolean emailExist(String email) {
		User user = userDAO.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}

}
