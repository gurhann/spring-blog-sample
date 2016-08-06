package com.gurhan.blogsample.persistence.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gurhan.blogsample.persistence.dao.GenericDAO;

public abstract class GenericDAOImp<T> implements GenericDAO<T> {
	private Class<T> clazz;

	@PersistenceContext
	EntityManager em;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	@Override
	public T findOne(long id) {
		return em.find(clazz, id);
	}

	@Override
	public List<T> findAll() {
		return em.createQuery("from " + clazz.getName()).getResultList();
	}

	@Override
	public void create(T entity) {
		em.persist(entity);
	}

	@Override
	public T update(T entity) {
		return em.merge(entity);
	}

	@Override
	public void delete(T entity) {
		em.remove(entity);
	}

	@Override
	public void deleteById(long id) {
		T entity = em.find(clazz, id);
		em.remove(entity);
	}
	
	@Override
	public int getRowCount() {
		return ((Long)em.createQuery("select count(d.id) from " + clazz.getName() + " d").getSingleResult()).intValue();
	}
}
