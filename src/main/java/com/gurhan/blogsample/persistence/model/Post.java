package com.gurhan.blogsample.persistence.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "post")
@NamedQueries({ 
	@NamedQuery(name = Post.GET_ALL_POST_BY_PAGE, query = "select p from Post p order by p.date desc"),
	@NamedQuery(name = Post.GET_POST_LIST_BY_USER, query = "select p from Post p where p.user.id=:userId order by p.date desc"),
	@NamedQuery(name = Post.GET_USER_POST_COUNT, query = "select count(p.id) from Post p where p.user.id=:userId")})
public class Post {
	public static final String GET_ALL_POST_BY_PAGE = "getAllPostByPage";
	public static final String GET_POST_LIST_BY_USER = "getPostListByUser";
	public static final String GET_USER_POST_COUNT = "getUserPostCount";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user;

	@Column(name = "title", length = 255)
	private String title;

	@Column(name = "url", length = 255)
	private String url;

	@Column(name = "text")
	private String text;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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
