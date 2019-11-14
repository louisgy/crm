package com.trafalgarcp.crm.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import com.trafalgarcp.crm.domain.CategorizedCompany;
import com.trafalgarcp.crm.domain.Category;
import com.trafalgarcp.crm.domain.Company;
import com.trafalgarcp.crm.domain.CompanyDetails;
import com.trafalgarcp.crm.domain.Industry;

import com.trafalgarcp.crm.domain.Professional;
import com.trafalgarcp.crm.repository.AddressRepository;
import com.trafalgarcp.crm.repository.CategorizedCompanyRepository;
import com.trafalgarcp.crm.repository.CategoryRepository;
import com.trafalgarcp.crm.repository.CompanyRepository;
import com.trafalgarcp.crm.repository.IndustryRepository;
import com.trafalgarcp.crm.repository.ProfessionalRepository;

@Controller
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategorizedCompanyRepository categorizedCompanyRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	ProfessionalRepository professionalRepository;

	@Autowired
	IndustryRepository industryRepository;
	

	@ModelAttribute("categories")
	public List<Category> addCategories() {
		return (this.categoryRepository.findAll());
	}

	/*
	 * Create new company, including address
	 */

	@GetMapping("/company/new")
	public String initCompanyForm(Model model) {

		Company company = new Company();

		Address address = new Address();
		
	

		//List<Industry> industries = this.industryRepository.findAll();

		model.addAttribute(company);
		model.addAttribute(address);

		return "/company/companyform-details";
	}

	/*
	 * Create new company, including address
	 */

	@PostMapping("/company/new")
	public String saveCompany(Address address, Company company, Model model, BindingResult bindingResult) {

		address.setCompany(company);
		company.getAddresses().add(address);

		this.companyRepository.save(company);

		CategorizedCompany categorizedCompany = new CategorizedCompany(company.getCategory(), company);
		this.categorizedCompanyRepository.save(categorizedCompany);

		return "/company";
	}
	
	/*
	 * List All Companies
	 */

	@GetMapping("/company")
	public String getCompanyList(Model model) {
		
		Company company = new Company();
		Category category = new Category();
		List<Company> companies = this.companyRepository.findAll();
		List<String> categories= this.categoryRepository.findDistinctCategorie();
		List<String> subcategories= this.categoryRepository.findDistinctSubcategorie();
		System.out.println("\n\n"+"*****____________****________--");        
		//companies.stream().forEach(s -> s.getCategorizedCompanies().forEach(t -> System.out.println(t.)));
    	System.out.println("\n\n"+"*****____________****________--");
		model.addAttribute("companies", companies);
		model.addAttribute("categories",categories);
		model.addAttribute("subcategories",subcategories);
		model.addAttribute("category",category);
		return "/company/company";
		
		
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

	/*
	 * Create a new Company. Address included.
	 */

//	@GetMapping("/company/new") 
//	public String showCompanyForm2(Model model) {
//		
//		List<Industry> industries = this.industryRepository.findAll();
//		
//		industries.stream().forEach((c) -> System.out.println(c.toString()));
//		
//		model.addAttribute(industries);
//		
//		model.addAttribute("companyDetails", new CompanyDetails());
//		
//		
//		
//		return "/company/companyform-details";
//	}

//	@ModelAttribute("industries")
//	public List<Industry> addIndustry(){
//		return(this.industryRepository.findAll());
//	}

	/*
	 * Industry Experimental
	 */
	@GetMapping("/company/industry-test")
	public String showIndustryExpr(Model model) {
		// model.addAttribute("",i)
		return "industry-test";
	}

	/*
	 * Industry Experimental
	 */
	@PostMapping("/company/industry-test")
	public String processIndustryExpr(Industry industry, Model model) {

		System.out.println(industry.toString());
		return "industry-test";
	}



	/*
	 * show a company data and addresses
	 */

	@GetMapping("/company/{id}")
	public String showCompany(@PathVariable Integer id, Model model) {
		Company company1 = new Company();
		Optional optionalCompany = companyRepository.findById(id);
		if (optionalCompany.isPresent()) {
			company1 = companyRepository.findById(id).get();
		}

//		Company company1= new Company();
//		
//			company1= companyRepository.findById(id);

		List<Address> addresses;
		List<Professional> professionals;

		addresses = addressRepository.findByCompanyId(id);
		professionals = professionalRepository.findByCompanyId(id);
		System.out.println("----------------------" + addresses.get(0).getCity());
		System.out.println("-----------" + " START list of addresses" + "-----------------");
		for (Address address : addresses) {

			System.out.println(address.getState());

		}
		System.out.println("-----------" + " END list of addresses" + "-----------------");

		model.addAttribute("professionals", professionals);
		model.addAttribute("addresses", addresses);
		model.addAttribute("company", company1);
		// return "companyshow";
		// return "/company/companyview";
		return "/company/company-view";
	}

	/*
	 * update company. Address not included
	 */

	@GetMapping("/company/{id}/edit")
	public String initUpdateCompanyForm(@PathVariable Integer id, Model model) {
		Company company = new Company();
		if (this.companyRepository.findById(id).isPresent()) {
			company = this.companyRepository.findById(id).get();
		}
		

		model.addAttribute("company", company);
		return "/company/company-form";
	}

	// Issues : find a way to update company without having to load addresses and
	// saved them again
	@PostMapping("/company/{id}/edit") // Submitting updated company form, address not included
	public String processUpdateCompanyForm(Company company, @PathVariable Integer id, Model model) {

		// company.setId(id);
		// this.companyRepository.update(company.getId(),company.getName());

		List<Address> addresses = new ArrayList<Address>();
		List<Professional> professionals = new ArrayList<Professional>();
		addresses = this.addressRepository.findByCompanyId(company.getId());
		professionals = this.professionalRepository.findByCompanyId(company.getId());
		company.setAddresses(addresses);
		company.setProfessionals(professionals);
		this.companyRepository.save(company);
		return "redirect:/company/" + company.getId();
	}

	@PostMapping("/new-company") // Process new company creation
	public String createNewCompany(@Valid @ModelAttribute CompanyDetails companyDetails, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			return "/company/companyform-details";
		}

		Company company1 = new Company();

		company1 = companyDetails.getCompany();

		Address address1 = new Address();

		address1 = companyDetails.getAddress();

		address1.setCompany(company1);

		company1.getAddresses().add(address1);

		companyRepository.save(company1);

		return "redirect:/company/" + company1.getId();
	}
	
	@GetMapping("/company/test")
	public String test() {
		return "/company/test";
	}
	

}
