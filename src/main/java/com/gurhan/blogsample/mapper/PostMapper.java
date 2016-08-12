package com.gurhan.blogsample.mapper;

import java.util.ArrayList;
import java.util.List;

import com.gurhan.blogsample.persistence.model.Post;
import com.gurhan.blogsample.web.dto.PostDTO;

public class PostMapper {
	public static PostDTO postModelToDTO(Post post) {
		PostDTO postDTO = new PostDTO();
		postDTO.setId(post.getId());
		postDTO.setTitle(post.getTitle());
		postDTO.setUrl(post.getUrl());
		postDTO.setUser(UserMapper.userModelToDTO(post.getUser()));
		postDTO.setDate(post.getDate());
		postDTO.setText(post.getText());
		return postDTO;
	}

	public static List<PostDTO> postListModelToDTO(List<Post> postList) {
		List<PostDTO> dtoList = new ArrayList<PostDTO>();
		for (Post post : postList) {
			dtoList.add(postModelToDTO(post));
		}
		return dtoList;
	}

	public static Post postDTOToModel(PostDTO postDTO) {
		Post post = new Post();
		post.setId(postDTO.getId());
		post.setTitle(postDTO.getTitle());
		post.setUrl(postDTO.getUrl());
		post.setUser(UserMapper.userDTOToModel(postDTO.getUser()));
		post.setDate(postDTO.getDate());
		post.setText(postDTO.getText());
		return post;
	}

	public static List<Post> postListDTOToModel(List<PostDTO> postDTOList) {
		List<Post> postList = new ArrayList<Post>();
		for (PostDTO postDTO : postDTOList) {
			postList.add(postDTOToModel(postDTO));
		}
		return postList;
	}
}
