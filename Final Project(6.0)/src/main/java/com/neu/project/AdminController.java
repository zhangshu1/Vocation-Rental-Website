package com.neu.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@RequestMapping(value="/admin/results.htm", method = RequestMethod.GET)
	public ModelAndView switchToResult() {
		return new ModelAndView("admininterface/householder-searchresults");
	}
	
	@RequestMapping(value="/admin/results2.htm", method = RequestMethod.GET)
	public ModelAndView switchToResult2() {
		return new ModelAndView("admininterface/householder-searchresults");
	}
	
	@RequestMapping(value="/householder/manage.htm", method = RequestMethod.GET)
	public ModelAndView switchToHouseHolder() {
		return new ModelAndView("admininterface/manage-householder");
	}
	
	@RequestMapping(value="/user/manage.htm", method = RequestMethod.GET)
	public ModelAndView switchToUser() {
		return new ModelAndView("admininterface/manage-user");
	}
}
