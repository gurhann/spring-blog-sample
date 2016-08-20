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

	@Override
	public PostDTO getPostById(Long id) {
		return PostMapper.postModelToDTO(postDAO.findOne(id));
	}

	@Override
	public void createPost(PostDTO post) {
		postDAO.create(PostMapper.postDTOToModel(post));
	}
	
	public void updatePost(PostDTO post){
		postDAO.update(PostMapper.postDTOToModel(post));
	}
	
	@Override
	public List<PostDTO> getPostsByUser(Long userId, int pageNumber) {
		return PostMapper.postListModelToDTO(postDAO.getPostListByUser(userId, pageNumber));
	}

	@Override
	public boolean isLastPage(int page) {
		int rowCount = postDAO.getRowCount();
		return calcLastPage(page, 5, rowCount);
	}

	@Override
	public boolean isLastPage(int page, int pageSize) {
		int rowCount = postDAO.getRowCount();
		return calcLastPage(page, pageSize, rowCount);
	}

	@Override
	public boolean isLastPageForUserPosts(Long userId, int page) {
		int rowCount = postDAO.getUserPostRowCount(userId);
		return calcLastPage(page, 5, rowCount);
	}

	@Override
	public boolean isLastPageForUserPosts(Long userId, int page, int pageSize) {
		int rowCount = postDAO.getUserPostRowCount(userId);
		return calcLastPage(page, pageSize, rowCount);
	}

	private boolean calcLastPage(int page, int pageSize, int rowCount) {
		if (rowCount % pageSize == 0) {
			return page == rowCount / pageSize;
		} else {
			return page == (rowCount / pageSize) + 1;
		}
	}

	
}
