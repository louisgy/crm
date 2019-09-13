package com.trafalgarcp.crm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trafalgarcp.crm.domain.Address;
import com.trafalgarcp.crm.domain.Company;
import com.trafalgarcp.crm.domain.CompanyDetails;
import com.trafalgarcp.crm.domain.Notes;
import com.trafalgarcp.crm.repository.CompanyRepository;

@Controller
public class CompanyController {
	
	@Autowired
	CompanyRepository companyRepository;
	@GetMapping("company")
	public String showCompany() {
		return "company";
	}
	
	@GetMapping("company-landing")
	public String showCompanyLanding() {
		return "company-landing";
	}
	
	
	@GetMapping("company-landing2")
	public String showCompanyLanding2() {
		return "company-landing2";
	}
	@GetMapping("add-company")
	public String addCompany() {
		return "company-add";
	}
	
	@GetMapping("company-landing3")
	public String showCompanyLanding3() {
		return "company-landing3";
	}
	
	@GetMapping("company-search")
	public String searchCompany() {
		return "company-search";
	}
	
	
	@GetMapping("/new-company")
	public String showCompanyForm(Model model) {
		
		model.addAttribute("companyDetails", new CompanyDetails());
		
		return "newcompany";
	}
	

	@GetMapping("/company-list")
	public String getCompanyList (Model model) {
		model.addAttribute("companies",companyRepository.findAll());
		return "company-list";
	}
	
	@GetMapping("/show-company")
	public String showCompany (Model model) {
		model.addAttribute("companies",companyRepository.findAll());
		return "company-list";
	}
	
	@GetMapping("/company/edit/{id}")
	public String edit (@PathVariable Integer id, Model model) {
		model.addAttribute("company",companyRepository.findById(id).get());
		return "companyform";
	}
	@PostMapping("company/update")
	public String updateCompany(Company company) {
		companyRepository.save(company);
		return "companyshow";
	}
	
	@PostMapping("/new-company")
	public String createNewCompany(@Valid @ModelAttribute  CompanyDetails companyDetails,BindingResult bindingResult) {
		
		if( bindingResult.hasErrors()) {
			
			return "newcompany";
		}
		
		Company company1 = new Company();
		
		company1 = companyDetails.getCompany();
		
		Address address1 = new Address();
		
		address1 = companyDetails.getAddress();
		
		address1.setCompany(company1);
		
		company1.getAddresses().add(address1);
		
		companyRepository.save(company1);
		
		return "company";
	}
	
	
	
}
