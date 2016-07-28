package com.gurhan.blogsample.persistence.dao;

import java.util.List;

import com.gurhan.blogsample.persistence.model.Post;

public interface PostDAO extends GenericDAO<Post> {
	public List<Post> getAllPostByPage(int pageNumber);
}
