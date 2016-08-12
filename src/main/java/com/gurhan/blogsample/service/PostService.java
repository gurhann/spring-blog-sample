package com.gurhan.blogsample.service;

import java.util.List;

import com.gurhan.blogsample.web.dto.PostDTO;

public interface PostService {

	public List<PostDTO> getAllPostByPage(int pageNumber);

	public PostDTO getPostById(Long id);
	
	public List<PostDTO> getPostsByUser(Long userId, int pageNumber);
	
	public void createPost(PostDTO post);
	
	public boolean isLastPage(int page);
	
	public boolean isLastPage(int page, int pageSize);
	
	public boolean isLastPageForUserPosts(Long userId, int page);
	
	public boolean isLastPageForUserPosts(Long userId, int page, int pageSize);

}
