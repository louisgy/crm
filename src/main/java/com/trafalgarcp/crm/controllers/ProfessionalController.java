package com.trafalgarcp.crm.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trafalgarcp.crm.domain.Company;
import com.trafalgarcp.crm.domain.Notes;
import com.trafalgarcp.crm.domain.Professional;
import com.trafalgarcp.crm.exception.ResourceNotFoundException;
import com.trafalgarcp.crm.repository.CompanyRepository;
import com.trafalgarcp.crm.repository.ProfessionalRepository;


@Controller
@RequestMapping("/company/{companyId}")
public class ProfessionalController {
	
	@Autowired
	ProfessionalRepository professionalRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@ModelAttribute("company")
	public Company findCompany(@PathVariable("companyId") Integer companyId) {
		String [] a = {"name","id"};
		Company company = new Company();
		company = this.companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("Company " + companyId + " not found"));
		System.out.println("MOdel Attribute : "+"\n\n");
		company.toString(a);
		return this.companyRepository.findById(companyId).orElseThrow(() -> new ResourceNotFoundException("Company " + companyId + " not found"));
	}
	
	@InitBinder("company")
	public void initCompanyBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@GetMapping("/professionals/new")
	public String initrofessionals(Company company, ModelMap model) {
		Professional professional = new Professional();
		company.addProfessional(professional);
		model.put("professional", professional);
		
		System.out.println("\n"+"SOMETHING HAPPEN HERE"+"\n");
		return "professionals/professionalsform";
	}
	

	
	@PostMapping("/professionals/new")
	public String processCreationForm(Company company,Professional professional, ModelMap model) {	
		company.addProfessional(professional);
		this.professionalRepository.save(professional);
		
		return "redirect:/company/"+company.getId()+"/professional/"+professional.getId();
	}
	
	
	@GetMapping("/professional")
	public String initCreationForm() {
		return "professionals/professionalview";
	}
	
	@GetMapping("/professional/{id}")
	public String showProfessional(@PathVariable Integer id, Model model) {
	   Professional professional = new Professional();
	   professional=this.professionalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Professional " + id + " not found"));
		model.addAttribute("professional",professional);
		return "professionals/professionalview";
	}
	
	/*
	 * Update professional
	 */
	
	@GetMapping("/professional/{professionalId}/edit")
	public String initUpdateProfessional(@PathVariable Integer professionalId,ModelMap model) {
		Professional professional = new Professional();
		professional = this.professionalRepository.findById(professionalId).orElseThrow(() -> new ResourceNotFoundException("Professional " + professionalId + " not found"));
		model.put("professional", professional);
		return "professionals/professionalsform";
	}
	
	/*
	 * Update professional
	 */
	
	@PostMapping("/professional/{professionalId}/edit")
	public String processUpdateProfessional(Professional professional, Company company,ModelMap model) {
		Company ncompany = new Company();
		ncompany.setId(company.getId());
		ncompany.addProfessional(professional);
		this.professionalRepository.save(professional);
		
		return "redirect:/company/"+company.getId()+"/professional/"+professional.getId();
	}
	
	
//	@GetMapping("/get-professionals")
//	public String showProfesionalsForm(Professionals professionals) {
//		
//		return "professionals-frm";
//	}
//	
//	@PostMapping("/new-professionals")
//	public String inputProfessionalss(@Valid  Professionals professionals, BindingResult bindingResult) {
//		
//	
//		if(bindingResult.hasErrors()) {
//			return "professionals-frm";
//			
//		} else {
//		
//		Professionals professional = new Professionals();
//		
//		profeRepository.save(professionals);
//		
//		return "company"; 
//		}
//		
//	}
	

	

	

}
