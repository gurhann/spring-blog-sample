package com.gurhan.blogsample.persistence.dao.jpa;

import org.springframework.stereotype.Repository;

import com.gurhan.blogsample.persistence.dao.AuthoritiesDAO;
import com.gurhan.blogsample.persistence.model.Authorities;

@Repository
public class AuthoritiesDAOImpl extends GenericDAOImp<Authorities> implements AuthoritiesDAO {

	public AuthoritiesDAOImpl() {
		setClazz(Authorities.class);
	}

}
