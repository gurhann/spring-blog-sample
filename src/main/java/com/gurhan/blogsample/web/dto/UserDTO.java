package com.gurhan.blogsample.web.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.gurhan.blogsample.validation.PasswordMatches;
import com.gurhan.blogsample.validation.ValidEmail;

@PasswordMatches
public class UserDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	@NotEmpty
	private String firstName;

	@NotNull
	@NotEmpty
	private String lastName;

	@NotNull
	@NotEmpty
	private String password;

	private String matchingPassword;

	@ValidEmail
	@NotNull
	@NotEmpty
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
