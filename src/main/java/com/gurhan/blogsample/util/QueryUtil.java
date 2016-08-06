package com.gurhan.blogsample.util;

import javax.persistence.Query;

import com.gurhan.blogsample.persistence.dao.GenericDAO;

public class QueryUtil {
	// default pageSize= 5
	public static Query getPageFromQuery(Query query, int pageNumber) {
		return query.setFirstResult(5 * (pageNumber - 1)).setMaxResults(pageNumber * 5);
	}

	public static Query getPageFromQuery(Query query, int pageNumber, int pageSize) {
		return query.setFirstResult(pageSize * (pageNumber - 1)).setMaxResults(pageNumber * pageSize);

	}
	
	public static boolean isLastPage(int pageNumber, GenericDAO dao) {
		int totalNumRow = dao.findAll().size();
		if(totalNumRow % 5 == 0) {
			return pageNumber == totalNumRow / 5;
		}else {
			return pageNumber == (totalNumRow / 5) + 1;
		}
	}
	
}
