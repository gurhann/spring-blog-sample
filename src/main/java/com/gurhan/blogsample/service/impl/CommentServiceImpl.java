package com.gurhan.blogsample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gurhan.blogsample.mapper.CommentMapper;
import com.gurhan.blogsample.persistence.dao.CommentDAO;
import com.gurhan.blogsample.service.CommentService;
import com.gurhan.blogsample.web.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public List<CommentDTO> getCommentsByPostId(Long postId) {
		return CommentMapper.CommentListModelToDTO(commentDAO.getCommentsByPostId(postId));
	}

	@Override
	public void addComment(CommentDTO comment) {
		commentDAO.create(CommentMapper.CommentDTOToModel(comment));
	}

}
