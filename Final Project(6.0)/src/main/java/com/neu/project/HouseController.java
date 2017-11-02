package com.neu.project;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.dao.HouseDAO;
import com.neu.dao.HouseHolderDAO;
import com.neu.exception.HouseException;
import com.neu.exception.HouseHolderException;
import com.neu.pojo.House;
import com.neu.pojo.HouseHolder;

@Controller
public class HouseController {
	

    @Autowired
    ServletContext servletContext;
	
	@RequestMapping(value = "/house/switch.htm", method = RequestMethod.GET)
	public ModelAndView switchTo() {
		return new ModelAndView("householderinterface/create-house");
	}
	
	@RequestMapping(value = "/house/add.htm", method = RequestMethod.GET)
	public ModelAndView createHouseModel() {
		System.out.print("add house");
        return new ModelAndView("householderinterface/create-house", "house", new House());
        
	}
	
	@RequestMapping(value = "/house/add.htm", method = RequestMethod.POST)
	public ModelAndView addHouse(HttpServletRequest request, @ModelAttribute("house") House house, BindingResult result) throws HouseException {
		try {
			if (house.getFilename().trim() != "" || house.getFilename() != null) {
				File directory;
				String check = File.separator; // Checking if system is linux
												// based or windows based by
												// checking seprator used.
				String path = null;
				if (check.equalsIgnoreCase("\\")) {
					path = servletContext.getRealPath("").replace("build\\", ""); // gives real path as Lab9/build/web/
																				  // so we need to replace build in the path
																						}

				if (check.equalsIgnoreCase("/")) {
					path = servletContext.getRealPath("").replace("build/", "");
					//path += "/"; // Adding trailing slash for Mac systems.
				}
				directory = new File(path + "//" + house.getFilename());
				boolean temp = directory.exists();
				if (!temp) {
					temp = directory.mkdir();
				}
				if (temp) {
					// We need to transfer to a file
					CommonsMultipartFile photoInMemory = house.getPhoto();

					String fileName = photoInMemory.getOriginalFilename();
					// could generate file names as well

					File localFile = new File(directory.getPath(), fileName);

					// move the file from memory to the file

					photoInMemory.transferTo(localFile);
					house.setFilename(localFile.getPath());
					System.out.println("File is stored at" + localFile.getPath());
					System.out.print("registerNewHouse");
					HouseDAO houseDao = new HouseDAO();
					
					//set the original status to unsold
					house.setStatus("unsold");
					HouseHolder householder = (HouseHolder) request.getSession().getAttribute("householder");
				    house.setOwner(householder);
					House h = houseDao.add(house);
					request.getSession().setAttribute("house", h);

				} else {
					System.out.println("Failed to create directory!");
				}
			}

		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("*** IOException: " + e.getMessage());
		} catch (HouseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("householderinterface/create-house");
	}

	
	@RequestMapping(value = "/house/browse.htm", method = RequestMethod.GET)
	public ModelAndView browseHouse() throws HouseException {
		HouseDAO houseDao = new HouseDAO();
		List<House> houses = houseDao.listUnsold();
		return new ModelAndView("userinterface/browse-house", "houses", houses);
	}
	
	@RequestMapping(value = "/house/detail.htm", method = RequestMethod.GET)
	public ModelAndView showDetail(HttpServletRequest request) throws HouseException {
		String id = request.getParameter("house");
		HouseDAO houseDao = new HouseDAO();
		House h = houseDao.search(id);
		return new ModelAndView("userinterface/house-detail","house",h);
	}
	
	@RequestMapping(value = "/house/mydetail.htm", method = RequestMethod.GET)
	public ModelAndView showMyDetail(HttpServletRequest request) throws HouseException {
		String id = request.getParameter("house");
		HouseDAO houseDao = new HouseDAO();
		House h = houseDao.search(id);
		return new ModelAndView("userinterface/house-detail","house",h);
	}
	
	@RequestMapping(value = "/house/mypost.htm", method = RequestMethod.GET)
	public ModelAndView viewMyPost(HttpServletRequest request) throws HouseHolderException, HouseException {
		HouseHolder h = (HouseHolder) request.getSession().getAttribute("householder");
		HouseDAO houseDao = new HouseDAO();
		List<House> results = houseDao.viewMyPost(String.valueOf(h.getPersonID()));
		return new ModelAndView("householderinterface/view-post","results",results);
	}
	
	@RequestMapping(value = "/house/useless.htm", method = RequestMethod.GET)
	public ModelAndView switchToUseless() {
		return new ModelAndView("userinterface/search");
	}
}
