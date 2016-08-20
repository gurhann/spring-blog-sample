package com.gurhan.blogsample.persistence.dao;

import java.util.List;

import com.gurhan.blogsample.persistence.model.Comment;

public interface CommentDAO extends GenericDAO<Comment>{
	
	public List<Comment> getCommentsByPostId(Long postId);
}
