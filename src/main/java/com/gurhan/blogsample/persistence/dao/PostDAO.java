package com.gurhan.blogsample.persistence.dao;

import java.util.List;

import com.gurhan.blogsample.persistence.model.Post;

public interface PostDAO extends GenericDAO<Post> {
	public List<Post> getAllPostByPage(int pageNumber);
	
	public List<Post> getPostListByUser(Long userId,int pageNumber);
	
	public int getUserPostRowCount(Long userId);
	
}