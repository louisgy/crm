package com.trafalgarcp.crm.domain;

import javax.validation.Valid;

public class CompanyDetails {
	
	public Address address;
	@Valid
	public Company company;
	

	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}

	
	
	
	

}
