package com.gurhan.blogsample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gurhan.blogsample.mapper.PostMapper;
import com.gurhan.blogsample.persistence.dao.PostDAO;
import com.gurhan.blogsample.persistence.model.Post;
import com.gurhan.blogsample.service.PostService;
import com.gurhan.blogsample.web.dto.PostDTO;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDAO postDAO;

	@Override
	public List<PostDTO> getAllPostByPage(int pageNumber) {
		List<PostDTO> result = new ArrayList<PostDTO>();
		List<Post> posts = postDAO.getAllPostByPage(pageNumber);
		for (Post post : posts) {
			result.add(PostMapper.postModelToDTO(post));
		}
		return result;
	}
}
