package com.neu.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController{
	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}
	
	@RequestMapping(value = "/signup.htm", method = RequestMethod.GET)
	public String switchTo() {
		return "sign-up";
	}
	
	@RequestMapping(value = "/person/householder.htm", method = RequestMethod.GET)
	public String showHouseholderSignupPage() {
		return "householderinterface/householder-signup";
	}
	
}
