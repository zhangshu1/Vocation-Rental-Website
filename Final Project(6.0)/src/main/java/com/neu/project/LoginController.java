package com.neu.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.HouseHolderDAO;
import com.neu.dao.UserDAO;
import com.neu.exception.HouseHolderException;
import com.neu.exception.UserException;
import com.neu.pojo.HouseHolder;
import com.neu.pojo.User;


@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@Autowired
	@Qualifier("householderDao")
	HouseHolderDAO householderDao;
	
	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView userLogin(HttpServletRequest request) throws UserException, HouseHolderException {
		
		HttpSession session = request.getSession();
		String role = request.getParameter("role");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
//		System.out.println("aaaaaaaaaaaaaa"+role);
		if(role.equalsIgnoreCase("householder")) {
//			HouseHolderDAO householderDao = new HouseHolderDAO();
			HouseHolder h = householderDao.get(username, password);
			if(h == null) {
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return new ModelAndView("error");
			} else {
				session.setAttribute("householder", h);
				return new ModelAndView("householderinterface/householder-home");
			}
			
		} else if(role.equalsIgnoreCase("user")){
			User u = userDao.get(username, password);
			
			if(u == null){
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return new ModelAndView("error");
		    } else {
		    	session.setAttribute("user", u);
		    	return new ModelAndView("userinterface/user-home");
		    }
	    } else {
	    	return new ModelAndView("admininterface/admin-home");
	    }
     }
	
	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if(session==null)
			return new ModelAndView("/index");
		else{
			session.removeAttribute("user");
			System.out.print("Logout");
			return new ModelAndView("/index", "user", new User());
		}
	}
}
