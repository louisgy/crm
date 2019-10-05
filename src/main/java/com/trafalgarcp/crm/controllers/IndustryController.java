package com.trafalgarcp.crm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.trafalgarcp.crm.domain.Industry;
import com.trafalgarcp.crm.repository.IndustryRepository;

@Controller
public class IndustryController {
	
	@Autowired
	IndustryRepository industryRepository;
	
	@GetMapping("/industry/new")
	public String showIndustryForm(Model model) {
		Industry industry = new Industry();
		//model.addAttribute("industry",industry);
		List<String> categories = new ArrayList<String>();
		List<String> subcategories = new ArrayList<String>();
		 subcategories = this.industryRepository.findDistinctSubcategory();
			
		 categories = this.industryRepository.findDistinctCategory();
	    
//		System.out.println("Categories"+"\n\n");        // FOR TESTING PURPOSES, ELIGIBLE FOR DELETE
//		categories.forEach(System.out::println);  
//		System.out.println("Sub Categories"+"\n\n");
//		subcategories.forEach(System.out::println);
		
		model.addAttribute("industry",industry);
		model.addAttribute("categories",categories);
		model.addAttribute("subcategories",subcategories);
		
		return "industry/industry-form";
	}
	
	@PostMapping("/industry/new")
	public String processIndustryForm(Industry industry,Model model) {
		System.out.println("\n"+"^^^^^^^^^^^^^^^^^^^^^^^"+industry.getCategory()+"^^^^^^^^^^^^^^^^^^^^^^^"+"\n");
		
		this.industryRepository.save(industry);
		return "industry/industry-view";
	}
	
	@GetMapping("/industry")
	public String showIndustries() {
		return "";
	}

}
