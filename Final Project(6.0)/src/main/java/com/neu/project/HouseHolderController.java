package com.neu.project;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.HouseHolderDAO;
import com.neu.exception.UserException;
import com.neu.pojo.HouseHolder;

@Controller
public class HouseHolderController {
	
	@Autowired
	ServletContext servletContext;

	// Householder sign up part
	@RequestMapping(value = "/householder/signup.htm", method = RequestMethod.GET)
	protected ModelAndView createHouseholderModel() throws Exception {
		System.out.print("registerHouseholder");

		return new ModelAndView("index", "householder", new HouseHolder());

	}

	@RequestMapping(value = "/householder/signup.htm", method = RequestMethod.POST)
	public ModelAndView createHouseHolder(HttpServletRequest request, @ModelAttribute("householder") HouseHolder householder, BindingResult result) throws UserException {

		// validator.validate(householder, result);
		if (result.hasErrors()) {
			return new ModelAndView("error", "householder", householder);
		} else {
			try {
				if (householder.getFilename().trim() != "" || householder.getFilename() != null) {
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
					directory = new File(path + "//" + householder.getFilename());
					boolean temp = directory.exists();
					if (!temp) {
						temp = directory.mkdir();
					}
					if (temp) {
						// We need to transfer to a file
						CommonsMultipartFile photoInMemory = householder.getPhoto();

						String fileName = photoInMemory.getOriginalFilename();
						// could generate file names as well

						File localFile = new File(directory.getPath(), fileName);

						// move the file from memory to the file

						photoInMemory.transferTo(localFile);
						householder.setFilename(localFile.getPath());
						System.out.println("File is stored at" + localFile.getPath());
						System.out.print("registerNewUser");
						HouseHolderDAO householderDao = new HouseHolderDAO();
						HouseHolder h = householderDao.register(householder);
						request.getSession().setAttribute("householder", h);

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

			return new ModelAndView("householderinterface/householder-home");
		}
	}
	
	@RequestMapping(value = "/householder/profile.htm", method = RequestMethod.GET)
	public ModelAndView showProfile(HttpServletRequest request) {
		HouseHolder householder = (HouseHolder) request.getSession().getAttribute("householder");
		return new ModelAndView("householderinterface/householder-profile", "householder", householder);
		}
}
