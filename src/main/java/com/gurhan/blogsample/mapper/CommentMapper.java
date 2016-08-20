package com.gurhan.blogsample.mapper;

import java.util.ArrayList;
import java.util.List;

import com.gurhan.blogsample.persistence.model.Comment;
import com.gurhan.blogsample.web.dto.CommentDTO;

public class CommentMapper {
	public static CommentDTO CommentModelToDTO(Comment comment) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(comment.getId());
		commentDTO.setPost(PostMapper.postModelToDTO(comment.getPost()));
		commentDTO.setUser(UserMapper.userModelToDTO(comment.getUser()));
		commentDTO.setText(comment.getText());
		return commentDTO;
	}

	public static List<CommentDTO> CommentListModelToDTO(List<Comment> commentList) {
		List<CommentDTO> dtoList = new ArrayList<CommentDTO>();
		for (Comment comment : commentList) {
			dtoList.add(CommentModelToDTO(comment));
		}
		return dtoList;
	}

	public static Comment CommentDTOToModel(CommentDTO commentDTO) {
		Comment comment = new Comment();
		comment.setId(commentDTO.getId());
		comment.setUser(UserMapper.userDTOToModel(commentDTO.getUser()));
		comment.setPost(PostMapper.postDTOToModel(commentDTO.getPost()));
		comment.setText(commentDTO.getText());
		return comment;
	}

	public static List<Comment> CommentListDTOToModel(List<CommentDTO> CommentDTOList) {
		List<Comment> CommentList = new ArrayList<Comment>();
		for (CommentDTO CommentDTO : CommentDTOList) {
			CommentList.add(CommentDTOToModel(CommentDTO));
		}
		return CommentList;
	}
}