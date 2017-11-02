package com.neu.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.neu.exception.HouseException;
import com.neu.exception.HouseHolderException;
import com.neu.pojo.House;
import com.neu.pojo.HouseHolder;

public class HouseDAO extends DAO{
public HouseDAO() {
		
	}
	
	public House add(House house) throws HouseException {
		try {
			begin();
			System.out.println("inside DAO");
	        getSession().save(house);
	        commit();
	        return house;
	        
		}catch(HibernateException e) {
			rollback();
			throw new HouseException("Exception while creating user: " + e.getMessage());
		}
	}
	
//	public void delete(House house) throws HouseException {
//		try {
//			begin();
//			getSession().delete(house);
//			commit();
//		} catch (HibernateException e) {
//			rollback();
//			throw new HouseException("Could not delete house " + house.getHouseID(), e);
//		}
//	}
	
	public List<House> listUnsold() {
		Criteria crit = getSession().createCriteria(House.class);
		crit.add(Restrictions.eq("status", "unsold"));
		List<House> results = crit.list();
		return results;
	}
	
	public House search(String id) throws HouseException {
//		long houseID = Long.valueOf(id).longValue();
		try{
			begin();
			Query q = getSession().createQuery("from House where houseID =:houseID");
			q.setString("houseID", id);
			House house = (House) q.uniqueResult();
			return house;
		} catch(HibernateException e) {
			rollback();
			throw new HouseException("Could not list houses", e);
		}
	}
	
	public House updateToSold(String id) throws HouseException {
		try{
			long houseID = Long.valueOf(id).longValue();
			begin();
			Query q = getSession().createQuery("update House set status=:status where houseID=:houseID");
			q.setString("status", "sold");
			q.setLong("houseID", houseID);
			House h = search(id);
			return h;
		} catch(HibernateException e) {
			rollback();
			throw new HouseException("Could not list houses", e);
		}
	}
	
	public List<House> viewMyPost(String id) throws HouseHolderException, HouseException {
		try{
			begin();
			long ID = Long.valueOf(id).longValue();
			Criteria crit = getSession().createCriteria(House.class);
			crit.add(Restrictions.eq("owner.personID", ID));
			List<House> results = crit.list();
			return results;
		} catch(HibernateException e) {
			rollback();
			throw new HouseException("Could not list houses", e);
		}
	}
}
