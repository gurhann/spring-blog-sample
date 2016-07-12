package com.gurhan.blogsample.constant;

public enum Role {
	ROLE_USER("ROLE_USER"), ROLE_ADMIN("ROLE_ADMIN");

	private String role;

	private Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
