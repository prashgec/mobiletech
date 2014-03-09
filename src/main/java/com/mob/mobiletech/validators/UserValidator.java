/**
 * 
 */
package com.mob.mobiletech.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mob.mobiletech.domain.User;

/**
 * @author Prashant
 *
 */
public class UserValidator implements Validator  {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object user, Errors error) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "firstName", "label.message.firstname.isrequired");
		
		
	}

}
