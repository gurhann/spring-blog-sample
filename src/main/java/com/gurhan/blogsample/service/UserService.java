package com.gurhan.blogsample.service;

import com.gurhan.blogsample.persistence.model.User;
import com.gurhan.blogsample.persistence.model.VerificationToken;
import com.gurhan.blogsample.validation.EmailExistException;
import com.gurhan.blogsample.web.dto.UserDTO;

public interface UserService {
	public User registerNewUserAccount(UserDTO accountDTO) throws EmailExistException;
	
	public User getUser(String verificationToken);
	
	public void saveRegisteredUser(User user);
	
	public void createVerificationToken(User user, String token);
	
	public VerificationToken getVerificationToken(String verificationToken);
	
}
