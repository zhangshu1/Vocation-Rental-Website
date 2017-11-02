package com.neu.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.TravelPlanDAO;
import com.neu.exception.TravelPlanException;
import com.neu.pojo.TravelPlan;

@Controller
public class TravelPlanController {
	
	@RequestMapping(value = "/travelplan/create.htm", method = RequestMethod.GET)
	public ModelAndView switchTo() {
		return new ModelAndView("userinterface/create-travelplan");
	}
	
	@RequestMapping(value = "/travelplan/add.htm", method = RequestMethod.GET)
	public ModelAndView createTravelPlanModel() {
		
		System.out.print("add travel plan");
		return new ModelAndView("householderinterface/create-post", "travelplan", new TravelPlan());
	}
	
	@RequestMapping(value = "/travelplan/add.htm", method = RequestMethod.POST)
	public ModelAndView addTravelPlan(HttpServletRequest request, @ModelAttribute("travelplan") TravelPlan travelplan, BindingResult result) throws TravelPlanException {
		TravelPlanDAO travelPlanDao = new TravelPlanDAO();
		TravelPlan t = travelPlanDao.add(travelplan);
		request.getSession().setAttribute("travelplan", t);
		System.out.println("Travel plan added successfully!");
		return new ModelAndView("householderinterface/create-post", "travelplan", t);
	}
}
