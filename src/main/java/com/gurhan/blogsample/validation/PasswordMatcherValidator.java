package com.gurhan.blogsample.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.gurhan.blogsample.web.dto.UserDTO;

public class PasswordMatcherValidator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		UserDTO user = (UserDTO) value;
		return user.getPassword().equals(user.getMatchingPassword());
	}

}
