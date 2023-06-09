package com.mmhernandez.auth.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mmhernandez.auth.models.User;

@Component
public class UserValidator implements Validator {
	
    // Specifies that an instance of the User Domain Model can be validated with this custom validator
    @Override
    public boolean supports(Class<?> c) {
        return User.class.equals(c);
    }
    
    // Creating our custom validation. We can add errors via .rejectValue(String, String)
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        if(!user.getPasswordConfirmation().equals(user.getPassword())) {
            // The first argument is the member variable of our Domain model that we are validating. The second argument is a code for us to use to set an error message.
            errors.rejectValue("confirmPassword", "Match");
        }
       
    }
}

