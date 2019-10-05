package com.trafalgarcp.crm.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;

@TableGenerator(name="Indstr_Gen",
table="ID_GEN",
pkColumnName="GEN_NAME",
valueColumnName="GEN_VAL",
pkColumnValue="indstr_Gen",
initialValue=500,
allocationSize=60)
@Entity
public class Industry {
	  @Id @GeneratedValue(generator="Indstr_Gen")
	private Integer id;
	private String category;
	
	private String subcategory;
	
    @ManyToMany(cascade = {
    		CascadeType.PERSIST,
    		CascadeType.MERGE
    })
    @JoinTable(name="INDSTR_COMP",
    		joinColumns=@JoinColumn(name="INDSTR_ID"),
    		inverseJoinColumns=@JoinColumn(name="COMP_ID")
    )
    
    
    private Set<Company> companies= new HashSet<>();
    
    public Industry() {
    	
    }
    
    public Industry(String category, String subcategory) {
		super();
		this.category = category;
		this.subcategory = subcategory;
		this.companies = companies;
	}

	public void  addCompany(Company company) {
    	companies.add(company);
        company.getIndustries().add(this);
    }
	
    public void removeCompany(Company company) {
    	companies.remove(company);
    	company.getIndustries().remove(this);
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	
	
	
	
	
	
}
