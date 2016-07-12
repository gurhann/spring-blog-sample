package com.gurhan.blogsample.persistence.dao.jpa;

import javax.annotation.PostConstruct;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gurhan.blogsample.persistence.dao.UserDAO;
import com.gurhan.blogsample.persistence.model.User;
import com.gurhan.blogsample.web.dto.UserDTO;

@Repository
public class UserDAOImpl extends GenericDAOImp<User> implements UserDAO {
	public UserDAOImpl() {
		setClazz(User.class);
	}

	@Override
	public User findByEmail(String email) {
		Query query = em.createNamedQuery(User.FIND_BY_EMAIL);
		query.setParameter("email", email);
		try {
			return (User) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
