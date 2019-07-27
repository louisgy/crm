package com.trafalgarcp.crm.controllers;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import com.trafalgarcp.crm.domain.User;
import com.trafalgarcp.crm.dto.Userdto;
import com.trafalgarcp.crm.dto.Userlogindto;
import com.trafalgarcp.crm.services.Userservice;

@Controller
public class UserController {

	@Autowired
	private Userservice userservice;

	@RequestMapping("/")
	public String loginForm(Model model) {
		model.addAttribute("userlogindto", new Userlogindto());
		return "index";
	}

	@PostMapping("/signin")
	public String landingSubmit(@ModelAttribute Userlogindto userlogindto) {

		return "landing";
	}

	@GetMapping("/signup")
	public String signupForm(Model model) {
		model.addAttribute("userdto", new Userdto("", "", "", "", "", ""));

		return "signup";
	}
	
	@GetMapping("/static")
	public String simplepage() {
		return "indext";
	}

//	@PostMapping("/signup")
//	public String signupUser(@ModelAttribute Userdto userdto) {	
//		userservice.signupUser(userdto);		
//	     return("landing");
//	}

	@PostMapping("/signup")
	public String signupUser(Userdto u, BindingResult bindingResult) throws NoSuchMethodException, SecurityException {
		Userdto userdt = null;
		
		String firstname = u.getFirstname();
		String lastname = u.getLastname();
		String username = u.getUsername();
		String email = u.getEmail();
		String password = u.getPassword();
		String matchingPassword = u.getMatchinpassword();
		
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		ExecutableValidator executableValidator = validator.forExecutables();

		//Set<ConstraintViolation<Userdto>> violations = validator.validate(u);
		
		DataBinder binder = new DataBinder(u);
		binder.setValidator((org.springframework.validation.Validator) validator);
		
		
		
		Set<ConstraintViolation<Userdto>> constraintViolations = executableValidator.validateConstructorParameters(
				Userdto.class.getConstructor(String.class, String.class, String.class, String.class, String.class,
						String.class),
				new Object[] { firstname, lastname, username, email, password, matchingPassword });
		
		
		for (ConstraintViolation<Userdto> violation : constraintViolations) {
			System.out.println(violation.getMessage());
		}
		
	//	if (constraintViolations.size() > 0 || (!violations.isEmpty())) {
			if (constraintViolations.size() > 0 ) {
			String message = constraintViolations.iterator().hasNext() ? constraintViolations.iterator().next().getMessage() : "";
			
			 StringBuilder strBuilder = new StringBuilder();
			for (ConstraintViolation<?> violation : constraintViolations) {
		        strBuilder.append(violation.getMessage() + ",");
		    }
			
			// throw new ConstraintViolationException(violations);
			
			System.out.println(message+"++++++++++++++++++++===================="+strBuilder);
		return  "signup";
		} else {
			userdt = new Userdto(u.getFirstname(), u.getLastname(), u.getUsername(), u.getEmail(), u.getPassword(),
					u.getMatchinpassword());
			userservice.signupUser(userdt);
			System.out.println(userdt);
			return ("landing");
		}
		
//		System.out.println("^^^^^^^^^^^^^^^^^^^"+"TEST SUCCESSFULL" +"---------------------");
//		System.out.println(userdt.toString());
//		System.out.println("^^^^^^^^^^^^^^^^^^^"+"TEST SUCCESSFULL" +"---------------------");
//		if (bindingResult.hasErrors()) {
//            return "signup";
//        } else {
//		userservice.signupUser(userdt);		
//		
//	     return("landing");
//        }
	}

	public boolean isAuthenticUser() {
		return true;
	}

	public boolean resetPassword() {
		return true;
	}

	public void edit() {

	}

}
