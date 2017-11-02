package com.neu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.neu.exception.RequestException;
import com.neu.pojo.Request;
import com.neu.pojo.User;


public class RequestDAO extends DAO{
	
	public RequestDAO() {
		
	}
	
	public Request add(Request request) throws RequestException {
		try {
			begin();
			System.out.println("inside DAO");
	        getSession().save(request);
	        commit();
	        return request;
	        
		}catch(HibernateException e) {
			rollback();
			throw new RequestException("Exception while creating request: " + e.getMessage());
		}
	}
	
	public List<Request> list(String userId) {
		long ID = Long.valueOf(userId).longValue();
		Criteria crit = getSession().createCriteria(Request.class);
		crit.add(Restrictions.eq("sender.personID", ID));
		List<Request> results = crit.list();
		return results;
	}
	
	public List<Request> orderHistory(User user) {
		Criteria crit = getSession().createCriteria(Request.class);
		crit.add(Restrictions.eq("sender.personID", user.getPersonID()));
		List<Request> results = crit.list();
		return results;
	}

}
