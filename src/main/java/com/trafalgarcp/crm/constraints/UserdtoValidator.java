package com.trafalgarcp.crm.constraints;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.passay.AlphabeticalSequenceRule;
import org.passay.DigitCharacterRule;
import org.passay.LengthRule;
import org.passay.NumericalSequenceRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.QwertySequenceRule;
import org.passay.RuleResult;
import org.passay.SpecialCharacterRule;
import org.passay.UppercaseCharacterRule;
import org.passay.WhitespaceRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



import com.trafalgarcp.crm.dto.Userdto;
import com.trafalgarcp.crm.services.Userservice;

@Component
public class UserdtoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		Userdto.class.equals(clazz);
		return false;
	}
	PasswordValidator validator;
	
	@Autowired
	private Userservice userservice;

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "firstname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "lastname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty");
		Userdto userdto = (Userdto) target;
		if (!checkValidEmail(userdto.getEmail())){
			errors.rejectValue("email", "email.invalid");
		} else if(userservice.isEmailAlreadyUsed(userdto.getEmail())) {
			errors.rejectValue("email", "email.alreadyused");
		}
		
		if(userservice.isUsernameAlreadyUsed(userdto.getUsername())) {
			errors.rejectValue("username", "username.alreadyused");
		}
		
		if(!userdto.getPassword().equals(userdto.getMatchinpassword())) {
			errors.rejectValue("password", "password.nomatch");
			errors.rejectValue("matchinpassword", "emailmachin.nomatch");
		}
		if(!checkValidPassword(userdto.getPassword())) {
			errors.rejectValue("password", "password.requirements");
		}

	}

	public boolean checkValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
	
	public boolean checkValidPassword(String password) {
		 validator = new PasswordValidator(Arrays.asList(
		           new LengthRule(8, 30), 
		           new UppercaseCharacterRule(1), 
		           new DigitCharacterRule(1), 
		           new SpecialCharacterRule(1), 
		           new NumericalSequenceRule(3,false), 
		           new AlphabeticalSequenceRule(3,false), 
		           new QwertySequenceRule(3,false),
		           new WhitespaceRule()));
		 
		        RuleResult result = validator.validate(new PasswordData(password));
		        if (result.isValid()) {
		            return true;
		        }
		        else

		        return false;
	}
	
	public boolean isEmailUnique () {
		return false;
	}
	
	public boolean isUsernameUnique () {
		return false;
	}

}
