package com.gurhan.blogsample.persistence.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gurhan.blogsample.persistence.dao.PostDAO;
import com.gurhan.blogsample.persistence.model.Post;
import com.gurhan.blogsample.util.QueryUtil;

@Repository
public class PostDAOImpl extends GenericDAOImp<Post> implements PostDAO {

	public PostDAOImpl() {
		setClazz(Post.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getAllPostByPage(int pageNumber) {
		Query query = QueryUtil.getPageFromQuery(em.createNamedQuery(Post.GET_ALL_POST_BY_PAGE),pageNumber);
		return (List<Post>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getPostListByUser(Long userId, int pageNumber) {
		Query query = QueryUtil
				.getPageFromQuery(em.createNamedQuery(Post.GET_POST_LIST_BY_USER).setParameter("userId", userId), pageNumber);
		return (List<Post>) query.getResultList();
	}

}
