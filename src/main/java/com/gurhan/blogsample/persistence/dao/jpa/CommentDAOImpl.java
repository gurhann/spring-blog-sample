package com.gurhan.blogsample.persistence.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gurhan.blogsample.persistence.dao.CommentDAO;
import com.gurhan.blogsample.persistence.model.Comment;

@Repository
public class CommentDAOImpl extends GenericDAOImp<Comment> implements CommentDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentsByPostId(Long postId) {
		Query query = em.createNamedQuery(Comment.GET_COMMENT_BY_POST_ID).setParameter("postId", postId);
		return (List<Comment>)query.getResultList();
	}

	
}
