package com.trafalgarcp.crm.controllers;

import java.util.List;
import java.util.Optional;

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
import com.trafalgarcp.crm.repository.AddressRepository;
import com.trafalgarcp.crm.repository.CompanyRepository;

@Controller
public class CompanyController {
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	AddressRepository addressRepository;
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
	
	
	@GetMapping("/company/new") // Show form to create company first time, address included
	public String showCompanyForm(Model model) {
		
		model.addAttribute("companyDetails", new CompanyDetails());
		
		return "newcompanyform";
	}
	

	@GetMapping("/companies")  // list all companies
	public String getCompanyList (Model model) {
		model.addAttribute("companies",companyRepository.findAll());
		return "companies";
	}
	
	@GetMapping("/company/{id}") // show a company data and addresses 
	public String showCompany (@PathVariable Integer id,Model model) {
		Company company1= new Company();
		Optional optionalCompany = companyRepository.findById(id);
		if(optionalCompany.isPresent()) {
			company1= companyRepository.findById(id).get();
		}
		List<Address> addresses;
		addresses = addressRepository.findByCompanyId(id);
		System.out.println("----------------------"+addresses.get(0).getCity());
		System.out.println("-----------"+" START list of addresses"+"-----------------");
		for(Address address: addresses) {
		
			System.out.println(address.getState());
			
		}
		System.out.println("-----------"+" END list of addresses"+"-----------------");
		
		model.addAttribute("addresses",addresses);
		model.addAttribute("company",company1);
		return "companyshow";
	}
	
	@GetMapping("/company/edit/{id}")  //Edit a company, address not included in  this form
	public String edit (@PathVariable Integer id, Model model) {
		model.addAttribute("company",companyRepository.findById(id).get());
		return "companyform";
	}
	@PostMapping("company/update") //company update
	public String saveCompany(Company company) {
		companyRepository.save(company);
		return "companyshow";
	}
	
	@PostMapping("/new-company") // Process new company creation
	public String createNewCompany(@Valid @ModelAttribute  CompanyDetails companyDetails,BindingResult bindingResult) {
		
		if( bindingResult.hasErrors()) {
			
			return "newcompanyform";
		}
		
		Company company1 = new Company();
		
		company1 = companyDetails.getCompany();
		
		Address address1 = new Address();
		
		address1 = companyDetails.getAddress();
		
		address1.setCompany(company1);
		
		company1.getAddresses().add(address1);
		
		companyRepository.save(company1);
	
		
		return "redirect:/company/"+company1.getId();
	}
	
	
	
}
