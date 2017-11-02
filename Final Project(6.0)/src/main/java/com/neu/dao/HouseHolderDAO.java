package com.neu.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.exception.HouseException;
import com.neu.exception.HouseHolderException;
import com.neu.exception.UserException;
import com.neu.pojo.House;
import com.neu.pojo.HouseHolder;

public class HouseHolderDAO extends DAO{
	
	public HouseHolderDAO() {
		
	}
	
	public HouseHolder get(String username, String password) throws HouseHolderException {
		try {
			begin();
			Query q = getSession().createQuery("from HouseHolder where userName = :username and password =:password");
			q.setString("username", username);
			q.setString("password", password);
			HouseHolder householder = (HouseHolder) q.uniqueResult();
			commit();
			return householder;
		} catch(HibernateException e) {
			rollback();
			throw new HouseHolderException("Could not get householder " + username, e);
		}
	}
	
	public HouseHolder register(HouseHolder householder) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");
	        getSession().save(householder);
	        commit();
	        return householder;
	        
		}catch(HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}
	
	public void delete(HouseHolder householder) throws UserException {
		try {
			begin();
			getSession().delete(householder);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete householder " + householder.getUserName(), e);
		}
	}
	
	public HouseHolder search(String id) throws HouseHolderException {
		try{
			begin();
			Query q = getSession().createQuery("from HouseHolder where personID =:personID");
			q.setString("personID", id);
			HouseHolder householder = (HouseHolder) q.uniqueResult();
			return householder;
		} catch(HibernateException e) {
			rollback();
			throw new HouseHolderException("Could not list householder", e);
		}
	}
}
