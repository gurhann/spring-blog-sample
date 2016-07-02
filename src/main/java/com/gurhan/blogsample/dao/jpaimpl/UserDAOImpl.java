package com.gurhan.blogsample.dao.jpaimpl;

import org.springframework.stereotype.Repository;

import com.gurhan.blogsample.dao.UserDAO;
import com.gurhan.blogsample.model.User;

@Repository
public class UserDAOImpl extends GenericDAOImp<User> implements UserDAO {
	public UserDAOImpl() {
		setClazz(User.class);
	}
}
