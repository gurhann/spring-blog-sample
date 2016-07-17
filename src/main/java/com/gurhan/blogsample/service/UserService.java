package com.gurhan.blogsample.service;

import com.gurhan.blogsample.persistence.model.User;
import com.gurhan.blogsample.validation.EmailExistException;
import com.gurhan.blogsample.web.dto.UserDTO;

public interface UserService {
	public User registerNewUserAccount(UserDTO accountDTO) throws EmailExistException;
	
	public void saveRegisteredUser(User user);
	
	
}
