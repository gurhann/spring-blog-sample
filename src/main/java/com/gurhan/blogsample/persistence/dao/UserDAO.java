package com.gurhan.blogsample.persistence.dao;

import com.gurhan.blogsample.persistence.model.User;

public interface UserDAO extends GenericDAO<User>{

	public User findByEmail(String email);
}
