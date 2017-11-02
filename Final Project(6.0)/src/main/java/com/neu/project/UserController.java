package com.neu.project;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.UserDAO;
import com.neu.exception.UserException;
import com.neu.pojo.User;
import com.neu.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDAO;
	
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "/person/user.htm", method = RequestMethod.GET)
	public String showUserSignupPage() {
		return "userinterface/user-signup";
	}

	// User sign up part
//	@RequestMapping(value = "/user/signup.htm", method = RequestMethod.GET)
//	protected ModelAndView createUserModel() throws Exception {
//		System.out.print("registerUser");
//
//		return new ModelAndView("index", "user", new User());
//
//	}

	@RequestMapping(value = "/user/signup.htm", method = RequestMethod.POST)
	public ModelAndView createUser(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult result)
			throws UserException {

		validator.validate(user, result);
		if (result.hasErrors()) {
			return new ModelAndView("error", "user", user);
		} else {
			try {
				if (user.getFilename().trim() != "" || user.getFilename() != null) {
					File directory;
					String check = File.separator; // Checking if system is
													// linux
													// based or windows based by
													// checking seprator used.
					String path = null;
					if (check.equalsIgnoreCase("\\")) {
						path = servletContext.getRealPath("").replace("build\\", "");
					}

					if (check.equalsIgnoreCase("/")) {
						path = servletContext.getRealPath("").replace("build/", "");
						// path += "/"; // Adding trailing slash for Mac
						// systems.
					}
					directory = new File(path + "//" + user.getFilename());
					boolean temp = directory.exists();
					if (!temp) {
						temp = directory.mkdir();
					}
					if (temp) {
						// We need to transfer to a file
						CommonsMultipartFile photoInMemory = user.getPhoto();

						String fileName = photoInMemory.getOriginalFilename();
						// could generate file names as well

						File localFile = new File(directory.getPath(), fileName);

						// move the file from memory to the file

						photoInMemory.transferTo(localFile);
						user.setFilename(localFile.getPath());
						System.out.println("File is stored at" + localFile.getPath());
						System.out.print("registerNewUser");
						UserDAO userDao = new UserDAO();
						User u = userDao.register(user);
						request.getSession().setAttribute("user", u);

					} else {
						System.out.println("Failed to create directory!");
					}
				}

			} catch (IllegalStateException e) {
				System.out.println("*** IllegalStateException: " + e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("*** IOException: " + e.getMessage());
			} catch (UserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return new ModelAndView("userinterface/user-home");
		}
	}

	@RequestMapping(value = "user/view.htm", method = RequestMethod.GET)
	public ModelAndView viewProfile(HttpServletRequest request) {

		HttpSession session = request.getSession();
		// String username = request.getParameter("username");
		// session.setAttribute("username", username);
		return new ModelAndView("userinterface/user-profile");
	}
}
