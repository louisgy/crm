package com.trafalgarcp.crm.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trafalgarcp.crm.domain.Address;
import com.trafalgarcp.crm.domain.Company;
import com.trafalgarcp.crm.repository.AddressRepository;
import com.trafalgarcp.crm.repository.CompanyRepository;
import com.trafalgarcp.crm.services.AddressService;
import com.trafalgarcp.crm.services.CompanyService;

@Controller
@RequestMapping("/company/{companyId}")
public class AddressController {
	
//	@Controller
//	public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
//	@Autowired
//	private CompanyService companyService;
	
	@Autowired
	private CompanyRepository companyRepository;
//	
	@Autowired
	private AddressRepository addressRepository;


	
	
	@ModelAttribute("company")
	public Company findCompany(@PathVariable("companyId") Integer companyId) {
		System.out.println("THIS IS MODELATTRIBUTE*************"+companyId);
		System.out.println("*************888");
		Company company = new Company();
		String [] var = {"name","website","id"};
		if(this.companyRepository.findById(companyId).isPresent())
			company=this.companyRepository.findById(companyId).get();
		company.toString(var);
		
		System.out.println("*************888");
		
		return company;	
	}
	
	@InitBinder("company")
	public void initCompanyBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@GetMapping("/address/new")
	public String initCreationForm(Company company, Model model) {
		Address address = new Address();
		
		company.getAddresses().add(address);
		
		address.setCompany(company);
		model.addAttribute("address",address);
		return "createOrUpdateAddressForm";	
	}
	
	@PostMapping("/address/new")
	public String initProcessForm(Company company,Address address, ModelMap model) {
		address.setCompany(company);
		company.getAddresses().add(address);
		
		String [] var = {"name","website","id"};
		company.toString(var);
		companyRepository.save(company);
		//addressService.save(address);
		return "redirect:/company/"+company.getId();
		
	}
	
	@GetMapping("/address/{addressId}/edit")
	public String initUpdateForm(@PathVariable Integer addressId,ModelMap model) {
		Address address = new Address();
		address = addressService.findAddressById(addressId);
		
		//model.addAttribute("address",address);
		model.put("address", address);
		
		String [] var = {"id","state","street"};
		address.toString(var);
		return "createOrUpdateAddressForm";	
	}
	
	
	@PostMapping("/address/{addressId}/edit")
	//public String processUpdateForm(Address address, @ModelAttribute(name = "company") Company ncompany,ModelMap model) {
		public String processUpdateForm(Address address, Company company,ModelMap model) {

		Company ncompany = new Company();
	    ncompany.setId(company.getId());
		

//		System.out.println("\n"+"EDIT PROCESS HAPPENED HERE"+"\n");
//		 System.out.println("COMPANY DETAILS BELOW");
//		 company.toString(new String []{"name","id"});
//		 System.out.println("\n"+"ADDRESS DETAILS BELOW:");
//		address.toString(new String [] {"id","state","street","companyid"});

		
		
		ncompany.addAddress(address);
		this.addressRepository.save(address);
		return "redirect:/company/"+company.getId();
	}
	

	

	

	
}
