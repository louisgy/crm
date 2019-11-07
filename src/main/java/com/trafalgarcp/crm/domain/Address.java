package com.trafalgarcp.crm.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@TableGenerator(name = "Addr_Gen", 
table = "ID_GEN", 
pkColumnName = "GEN_NAME", 
valueColumnName = "GEN_VAL", 
pkColumnValue = "Addrs_Gen", 
initialValue = 10000, 
allocationSize = 60)
@Entity
public class Address {
	
	@Id @GeneratedValue(generator = "Addr_Gen")
	private Integer id;
	
	@ManyToOne(
			fetch = FetchType.LAZY
			)
	@JoinColumn(name="companyId",nullable=false)
	private Company company;
	
	
	private int    zipcode;
	private String state;
	private String city;
    private String street;
    private String Country;

	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Address(int zipcode, String state, String city, String street, String country) {
		super();
		this.zipcode = zipcode;
		this.state = state;
		this.city = city;
		this.street = street;
		Country = country;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setCompany(Company company) {
		setCompany(company,true);
	}

	void setCompany(Company company, boolean add) {
		this.company=company;
		if(company!= null && add) {
			company.addAddress(this,false);
		}
	}

	public Company getCompany() {
		return company;
	}
	
	
//	public void setCompany(Company company) {
//		this.company = company;
//	}
	
	
	public int getZipcode() {
		return zipcode;
	}
	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}




	@Override
	public String toString() {
		return "Address [id=" + id + ", company=" + company + ", zipcode=" + zipcode + ", state=" + state + ", city="
				+ city + ", street=" + street + "]";
	}
	
	
	public void toString(String [] variables) {
		for(String variable : variables) {
			if( variable=="street")
				System.out.println("\n"+"Street:" +getStreet());
			else if( variable=="state")
				System.out.println("\n"+"State :" +getState());
			else if( variable=="city")
				System.out.println("\n"+"City :" +getCity());
			else if( variable=="zipcode")
				System.out.println("\n"+"zipcode :" +getZipcode());
			else if( variable=="id")
				System.out.println("\n"+"Address Id :" +getId());
			else if( variable=="companyid")
				System.out.println("\n"+"company Id :" +getCompany());
		}
		
	}

}
