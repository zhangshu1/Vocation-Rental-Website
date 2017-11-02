package com.neu.dao;

import org.hibernate.HibernateException;

import com.neu.exception.TravelPlanException;
import com.neu.pojo.TravelPlan;

public class TravelPlanDAO extends DAO{
	
	public TravelPlanDAO() {
		
	}
	
	public TravelPlan add(TravelPlan travelplan) throws TravelPlanException {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(travelplan);
			commit();
			return travelplan;
		} catch(HibernateException e) {
			rollback();
			throw new TravelPlanException("Exception while adding travelplan: " + e.getMessage());
		}
	}

	public void delete(TravelPlan travelplan) throws TravelPlanException {
		try {
			begin();
			getSession().delete(travelplan);
			commit();
		} catch(HibernateException e) {
			rollback();
			throw new TravelPlanException("Could delete travelplan: " + travelplan.getPlanID(),e);
		}
		
	}
}
