package com.trafalgarcp.crm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {
	
	@GetMapping("company")
	public String showCompany() {
		return "company";
	}
	
	@GetMapping("company-landing")
	public String showCompanyLanding() {
		return "company-landing";
	}
	
	@GetMapping("add-company")
	public String addCompany() {
		return "company-add";
	}
	
	@GetMapping("company-search")
	public String searchCompany() {
		return "company-search";
	}
	
	
	
}
