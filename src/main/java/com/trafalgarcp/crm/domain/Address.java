package com.trafalgarcp.crm.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public int getZipcode() {
		return zipcode;
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
		}
		
	}

}
