package com.neu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.exception.UserException;
import com.neu.pojo.User;

public class UserDAO extends DAO{
	
	public UserDAO() {
		
	}
	
	public User get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where userName = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);			
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	
	public User register(User user) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");
	        getSession().save(user);
	        commit();
	        return user;
	        
		}catch(HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	
	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getUserName(), e);
		}
	}
	
	public User search(String id) throws UserException {
		try{
			begin();
			Query q = getSession().createQuery("from User where personID =:personID");
			q.setString("personID", id);
			User user = (User) q.uniqueResult();
			return user;
		} catch(HibernateException e) {
			rollback();
			throw new UserException("Could not list user", e);
		}
	}
}
