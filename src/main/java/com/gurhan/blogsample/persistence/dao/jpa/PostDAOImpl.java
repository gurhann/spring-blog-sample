package com.gurhan.blogsample.persistence.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gurhan.blogsample.persistence.dao.PostDAO;
import com.gurhan.blogsample.persistence.model.Post;

@Repository
public class PostDAOImpl extends GenericDAOImp<Post> implements PostDAO {


	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getAllPostByPage(int pageNumber) {
		Query query = em.createNamedQuery(Post.GET_ALL_POST_BY_PAGE).setFirstResult(pageNumber-1).setMaxResults(pageNumber*5);
		return (List<Post>)query.getResultList();
	}

}
