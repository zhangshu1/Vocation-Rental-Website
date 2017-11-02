package com.neu.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.HouseDAO;
import com.neu.dao.HouseHolderDAO;
import com.neu.dao.RequestDAO;
import com.neu.dao.UserDAO;
import com.neu.exception.HouseException;
import com.neu.exception.HouseHolderException;
import com.neu.exception.RequestException;
import com.neu.exception.UserException;
import com.neu.pojo.House;
import com.neu.pojo.HouseHolder;
import com.neu.pojo.Request;
import com.neu.pojo.User;

@Controller
public class RequestController {
	
	//delete house and set request
	@RequestMapping(value = "/request/send.htm", method = RequestMethod.GET)
	public ModelAndView sendRequest(HttpServletRequest request) throws HouseException, UserException, HouseHolderException, RequestException {
		String houseId = request.getParameter("house");
		String userId = request.getParameter("user");
		String householderId = request.getParameter("householder");
		
		//update house status
		HouseDAO houseDao = new HouseDAO();
		houseDao.updateToSold(houseId);
		House house = houseDao.search(houseId);
		
		Request req = new Request();
		UserDAO userDao = new UserDAO();
		User user = userDao.search(userId);
		HouseHolderDAO householderDao = new HouseHolderDAO();
		HouseHolder householder = householderDao.search(householderId);
		req.setHouse(house);
		req.setSender(user);
		req.setReceiver(householder);
		RequestDAO requestDao = new RequestDAO();
		requestDao.add(req);
		return new ModelAndView("userinterface/check-success","request",req);
	}
	
	//browse the inbox
	@RequestMapping(value = "/request/browse.htm", method = RequestMethod.GET)
	public ModelAndView browseRequest(HttpServletRequest request) throws UserException {
		String userId = request.getParameter("user");
//		System.out.println("aaaaaaaaaa" + userId);
		RequestDAO requestDao = new RequestDAO();
	    List<Request> results = requestDao.list(userId);
		return new ModelAndView("userinterface/inbox", "results", results);
	}
	
	@RequestMapping(value = "/request/history.htm", method = RequestMethod.GET)
	public ModelAndView requestHistory(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		RequestDAO requestDao = new RequestDAO();
		List<Request> orders = requestDao.orderHistory(user);
		return new ModelAndView("userinterface/order-history", "orders", orders);
	}
}
