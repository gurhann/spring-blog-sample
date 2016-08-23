package com.gurhan.blogsample.web.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.gurhan.blogsample.validation.PasswordMatches;
import com.gurhan.blogsample.validation.ValidEmail;

@PasswordMatches
public class UserDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull(message = "{label.firstname.notnull}")
	@NotEmpty(message = "{label.firstname.notnull}")
	private String firstName;

	@NotNull(message = "{label.lastname.notnull}")
	@NotEmpty(message = "{label.lastname.notnull}")
	private String lastName;

	@NotNull(message = "{label.password.notnull}")
	@NotEmpty(message = "{label.password.notnull}")
	private String password;
	
		
	private String matchingPassword;

	@NotNull(message = "{label.email.notnull}")
	@NotEmpty(message = "{label.email.notnull}")
	@ValidEmail(message = "{label.not.email}")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
