package com.gurhan.blogsample.persistence.dao;

import java.sql.Date;
import java.util.stream.Stream;

import com.gurhan.blogsample.persistence.model.User;
import com.gurhan.blogsample.persistence.model.VerificationToken;

public interface VerificationTokenDAO extends GenericDAO<VerificationToken>{
	
	public VerificationToken findByToken(String token);
	public VerificationToken findByUser(User user);
	public Stream<VerificationToken> findAllByExpiryDateLessThan(Date now);
	public void deleteByExpiryDateLessThan(Date now);
	public void deleteByExpiredSince(Date date);

}
