package com.gurhan.blogsample.service;

import java.util.List;

import com.gurhan.blogsample.web.dto.CommentDTO;

public interface CommentService {
	public List<CommentDTO> getCommentsByPostId(Long postId);
	
	public void addComment(CommentDTO comment);
	
	
}
