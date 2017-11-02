package com.neu.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.neu.pojo.HouseHolder;

public class HouseHolderValidator {
	
	public boolean supports(Class aClass) {
		return aClass.equals(HouseHolder.class);
	}

	public void validate(Object obj, Errors errors) {
		HouseHolder householder = (HouseHolder) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.user", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email","Email Required");
		
		// check if user exists
		
	}
}
