package com.neu.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.pojo.User;

public class UserValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(User.class);
	}

	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.invalid.user", "User Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.email","Email Required");
		
		// check if user exists
		
	}
}
