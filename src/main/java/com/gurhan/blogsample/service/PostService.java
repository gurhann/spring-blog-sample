package com.gurhan.blogsample.service;

import java.util.List;

import com.gurhan.blogsample.web.dto.PostDTO;

public interface PostService {
	public List<PostDTO> getAllPostByPage(int pageNumber);
}
