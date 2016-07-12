package com.gurhan.blogsample.persistence.dao.jpa;

import java.sql.Date;
import java.util.stream.Stream;

import javax.management.Query;
import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.gurhan.blogsample.persistence.dao.VerificationTokenDAO;
import com.gurhan.blogsample.persistence.model.User;
import com.gurhan.blogsample.persistence.model.VerificationToken;

@Repository
public class VerificationTokenDATOImpl extends GenericDAOImp<VerificationToken> implements VerificationTokenDAO {
	public VerificationTokenDATOImpl() {
		setClazz(VerificationToken.class);
	}

	@Override
	public VerificationToken findByToken(String token) {
		try {
			return (VerificationToken) em.createNamedQuery(VerificationToken.FIND_BY_TOKEN).setParameter("token", token)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public VerificationToken findByUser(User user) {
		try {
			return (VerificationToken) em.createNamedQuery(VerificationToken.FIND_BY_USER)
					.setParameter("userId", user.getId()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Stream<VerificationToken> findAllByExpiryDateLessThan(Date now) {

		return null;
	}

	@Override
	public void deleteByExpiryDateLessThan(Date now) {
		em.createQuery(VerificationToken.DELETE_BY_EXPIRY_DATE_LESS_THAN).setParameter("expiryDate", now)
				.executeUpdate();
	}

	@Override
	public void deleteByExpiredSince(Date date) {
		em.createQuery(VerificationToken.DELETE_ALL_EXPIRED_SINCE).setParameter("expiryDate", date).executeUpdate();
	}

}
