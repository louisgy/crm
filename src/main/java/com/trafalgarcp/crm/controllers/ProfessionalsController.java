package com.trafalgarcp.crm.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trafalgarcp.crm.domain.Notes;
import com.trafalgarcp.crm.domain.Professionals;
import com.trafalgarcp.crm.repository.ProfessionalsRepository;

@Controller
public class ProfessionalsController {
	
	@Autowired
	ProfessionalsRepository profeRepository;
	
	@GetMapping("/get-professionals")
	public String showProfesionalsForm(Professionals professionals) {
		
		return "professionals-frm";
	}
	
	@PostMapping("/new-professionals")
	public String inputProfessionals(@Valid  Professionals professionals, BindingResult bindingResult) {
		
	
		if(bindingResult.hasErrors()) {
			return "professionals-frm";
			
		} else {
		
		Professionals professional = new Professionals();
		
		profeRepository.save(professionals);
		
		return "company"; 
		}
		
	}
	

	

}
