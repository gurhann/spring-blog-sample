package com.gurhan.blogsample.web.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class PostDTO {
	private Long id;
	private UserDTO user;
	@NotNull(message = "{label.notnull.posttitle}")
	@NotEmpty(message = "{label.notnull.posttitle}")
	@Size(max = 255, message = "{label.max.posttitle}")
	private String title;
	private String url;
	@NotNull(message = "{label.notnull.posttext}")
	@NotEmpty(message = "{label.notnull.posttext}")
	private String text;
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
