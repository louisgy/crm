package com.trafalgarcp.crm.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.trafalgarcp.crm.domain.Address;
import com.trafalgarcp.crm.domain.Professional;

import ch.qos.logback.core.net.SyslogOutputStream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@TableGenerator(name = "Comp_Gen", 
table = "ID_GEN", 
pkColumnName = "GEN_NAME", 
valueColumnName = "GEN_VAL", 
pkColumnValue = "Cmp_Gen", 
initialValue = 80000, 
allocationSize = 60)
@Entity
public class Company {
	

	@Id @GeneratedValue(generator = "Comp_Gen")
	private Integer id;

//	@NotNull
	@NotBlank
	private String name;
	private String website;
	@Digits(fraction = 0, integer = 6)
	private int yearFounded;
	@Digits(fraction = 0, integer = 10, message = " Number of employeees must a number betweent 0 and 9999999999")
	private int numEmployees;
	private String relationship;
	private String primaryPhone;
	private String secondaryPhone;
	@Column(length =7000)
	private String description;
	private Date fiscalYear;
	private String currency;
	private BigDecimal revenue;
	private BigDecimal ebidta;
	@Transient
	private Industry industry; // used for list in Company form -- TO BE DELETED
	@Transient
	private Category category; // used for list in Company form

	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> addresses = new ArrayList<>();
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Professional> professionals = new ArrayList<>();
	
	@ManyToMany(mappedBy = "companies") // should be deleted thereafter
	private Set<Industry> industries = new HashSet<>(); // should be deleted thereafter
	
	@OneToMany(mappedBy = "company",fetch = FetchType.EAGER)
    protected Set<CategorizedCompany> categorizedCompanies = new HashSet<>();


	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Company(@NotNull @NotBlank String name, String website, @Digits(fraction = 0, integer = 6) int yearFounded,
			@Digits(fraction = 0, integer = 10, message = " Number of employeees must a number betweent 0 and 9999999999") int numEmployees,
			String primaryPhone, String secondaryPhone, String description, Date fiscalYear, String currency,
			BigDecimal revenue, BigDecimal ebidta) {
		super();
		this.name = name;
		this.website = website;
		this.yearFounded = yearFounded;
		this.numEmployees = numEmployees;
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
		this.description = description;
		this.fiscalYear = fiscalYear;
		this.currency = currency;
		this.revenue = revenue;
		this.ebidta = ebidta;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	


//	public void addAddress(Address address) {
//		getAddresses().add(address);
//		address.setCompany(this);
//	}
	
	


	protected List<Professional> getProfessionalsInternal() {
        if (this.professionals == null) {
            this.professionals = new ArrayList<>();
        }
        return this.professionals;
    }
	
//	public void addProfessional(Professional professional) {
//		if (professional.isNew()) {
//			getProfessionalsInternal().add(professional);
//        }
//        professional.setCompany(this);
//	}

	
	

	public void removeAddress(Address address) {
		getAddresses().remove(address);
		address.setCompany(null);
	}
	
	public Set<Industry> getIndustries() {
		return industries;
	}


	public void setIndustries(Set<Industry> industries) {
		this.industries = industries;
	}


	public void addAddress(Address address) {
		addAddress(address, true);
	}
	
	public void addAddress(Address address, boolean set) {
		if(address != null) {
			if(getAddresses().contains(address)) {
				getAddresses().set(getAddresses().indexOf(address),address);
			} else {
				getAddresses().add(address);
			} 
			if(set) {
				address.setCompany(this,false);
			}
		}
	}
	
	public void addProfessional(Professional professional) {
		addProfessional(professional, true);
	}
	
	public void addProfessional(Professional professional, boolean set) {
		if(professional != null) {
			if(getProfessionals().contains(professional)) {
				getProfessionals().set(getAddresses().indexOf(professional),professional);
			} else {
				getProfessionals().add(professional);
			} 
			if(set) {
				professional.setCompany(this,false);
			}
		}
	}
	
	

	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public String getRelationship() {
		return relationship;
	}



	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}



	public Set<CategorizedCompany> getCategorizedCompanies() {
		return categorizedCompanies;
	}



	public void setCategorizedCompanies(Set<CategorizedCompany> categorizedCompanies) {
		this.categorizedCompanies = categorizedCompanies;
	}



	public List<Professional> getProfessionals() {
		return professionals;
	}


	public void setProfessionals(List<Professional> professionals) {
		this.professionals = professionals;
	}


	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	

	public Industry getIndustry() {
		return industry;
	}



	public void setIndustry(Industry industry) {
		this.industry = industry;
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

	

	public int getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}


	
	



	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getFiscalYear() {
		return fiscalYear;
	}


	public void setFiscalYear(Date fiscalYear) {
		this.fiscalYear = fiscalYear;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public BigDecimal getRevenue() {
		return revenue;
	}


	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}


	public BigDecimal getEbidta() {
		return ebidta;
	}


	public void setEbidta(BigDecimal ebidta) {
		this.ebidta = ebidta;
	}
	

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", website=" + website + ", yearFounded=" + yearFounded
				+ ", numEmployees=" + numEmployees + ", primaryPhone=" + primaryPhone + ", secondaryPhone="
				+ secondaryPhone + ", description=" + description + ", fiscalYear=" + fiscalYear + ", currency="
				+ currency + ", revenue=" + revenue + ", ebidta=" + ebidta + ", addresses=" + addresses
				+ ", professionals=" + professionals + "]";
	}


	public void toString(String [] variables) {
		for(String variable : variables) {
			if( variable=="name")
				System.out.println("\n"+"Street:" +getName());
			else if( variable=="website")
				System.out.println("\n"+"Website :" +getWebsite());
			else if( variable=="comments")
				System.out.println("\n"+"Description :" +getDescription());
			else if( variable=="yearfounded")
				System.out.println("\n"+"Year Founded :" +getYearFounded());
			else if( variable=="id")
				System.out.println("\n"+"Company Id :" +getId());
			else if( variable=="addresses")
			{
				for(Address address : addresses)
				System.out.println("\n"+"Addresses :" +getAddresses().toString());
			}
		}
		
	}

}
