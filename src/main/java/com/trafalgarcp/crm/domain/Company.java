package com.trafalgarcp.crm.domain;

import java.util.ArrayList;
import java.util.List;

import com.trafalgarcp.crm.domain.Address;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@TableGenerator(name = "Comp_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Ucom_Gen", initialValue = 60000, allocationSize = 4)
public class Company {

	@Id
	@GeneratedValue(generator = "User_Gen")
	private Integer id;

	@NotNull
	@NotBlank
	private String name;
	private String website;
	@Digits(fraction = 0, integer = 6)
	private int yearFounded;
	@Digits(fraction = 0, integer = 10, message = " Number of employeees must a number betweent 0 and 9999999999")
	private int numEmployees;
	private String description;
	private float totalRevenue;
	private float grossProfit;
	private float totalAsset;
	private String primaryPhone;
	private String secondaryPhone;
	private String tertiaryPhone;

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> addresses = new ArrayList<>();

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void addAddress(Address address) {
		addresses.add(address);
		address.setCompany(this);
	}

	public void removeAddress(Address address) {
		addresses.add(address);
		address.setCompany(this);
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getNumEmployees() {
		return numEmployees;
	}

	public void setNumEmployees(int numEmployees) {
		this.numEmployees = numEmployees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(float totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public float getGrossProfit() {
		return grossProfit;
	}

	public void setGrossProfit(float grossProfit) {
		this.grossProfit = grossProfit;
	}

	public float getTotalAsset() {
		return totalAsset;
	}

	public void setTotalAsset(float totalAsset) {
		this.totalAsset = totalAsset;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public String getTertiaryPhone() {
		return tertiaryPhone;
	}

	public void setTertiaryPhone(String tertiaryPhone) {
		this.tertiaryPhone = tertiaryPhone;
	}

	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", website=" + website + ", yearFounded=" + yearFounded
				+ ", numEmployees=" + numEmployees + ", description=" + description + ", totalRevenue=" + totalRevenue
				+ ", grossProfit=" + grossProfit + ", totalAsset=" + totalAsset + ", primaryPhone=" + primaryPhone
				+ ", secondaryPhone=" + secondaryPhone + ", tertiaryPhone=" + tertiaryPhone + ", addresses=" + addresses
				+ "]";
	}
	
	public void toString(String [] variables) {
		for(String variable : variables) {
			if( variable=="name")
				System.out.println("\n"+"Street:" +getName());
			else if( variable=="website")
				System.out.println("\n"+"Website :" +getWebsite());
			else if( variable=="description")
				System.out.println("\n"+"Description :" +getDescription());
			else if( variable=="yearfounded")
				System.out.println("\n"+"Year Founded :" +getYearFounded());
			else if( variable=="id")
				System.out.println("\n"+"Company Id :" +getId());
		}
		
	}

}
