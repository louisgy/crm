package com.trafalgarcp.crm.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trafalgarcp.crm.domain.Address;
import com.trafalgarcp.crm.domain.Company;
import com.trafalgarcp.crm.repository.AddressRepository;
import com.trafalgarcp.crm.repository.CompanyRepository;
import com.trafalgarcp.crm.services.AddressService;
import com.trafalgarcp.crm.services.CompanyService;

@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	AddressRepository addressRepository; 
	

	
	@GetMapping("/company/{id}/address/new") //Crate or update address
	public String showAddress(@PathVariable int id,Company company, Address address,Model model) {

		System.out.println("______________________----==="+id);
//		Address address = new Address();
//		Company company = new Company();
//		Optional <Company>optionalCompany = companyRepository.findById(id);
//		if(optionalCompany.isPresent()) {
//			company= optionalCompany.get();
//			address.setCompany(company);
//			company.addAddress(address);
//			model.put("address", address);
//			model.put("company", company);
//		}
//		else {
//			return "";
//		}
//		
		model.addAttribute("company",company);
		model.addAttribute("address",new Address());
		return "addressform";
	}
	
	// SAVE and UPDATE new company  
	
	@PostMapping("/company/{id}/address/new")
	public String saveAddress(@PathVariable Integer id,Address address,Company company) {

	System.out.println("\n"+"************ POST-SAVE AND UPDATE"+address.toString()+"\n"+company.toString()+"\n");
		
		
		address = addressService.save(address, company.getId());

	    return "redirect:/company/"+company.getId();
	}
	
	@GetMapping("/company/{id}/address/edit")
	public String showEditAddress() {
		return "";
	}
	
	@PostMapping("/addressform/update")
	public String updateAddress(Company company, Address address) {
		return "";
	}
	
	// Edit a particular address for a particular company.
	
	@GetMapping("/company/{cid}/address/{aid}") 
	public String showEditAddress(@PathVariable int cid,@PathVariable int aid, Model model) {
		Company company = new Company();
		company = companyService.findCompanyById(cid);
		Address address = new Address();
		address = addressService.findAddressById(aid);
		String address_param [] = {"street","zipcode","state","city","id"};
		address.toString(address_param);
		String company_param [] = {"name","description","yearfounded","website","id"};
		company.toString(company_param);
		model.addAttribute("company",company);	
		model.addAttribute("address",address);
		model.addAttribute("companyId",cid);
		return "addressform";
	}
	

	
}
