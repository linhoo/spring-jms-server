package org.tobby.jms.spring.server.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MyValidator implements Validator {



	public void validate(Object target, Errors errors) {
		System.out.println("Validating------------------------" + target);
		//errors.rejectValue("value", "NULLVALUE", "I reject you");
		//errors.reject("NULLVALUE", "I reject you");
	}

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

}
