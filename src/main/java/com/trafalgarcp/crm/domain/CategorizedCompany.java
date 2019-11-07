package com.trafalgarcp.crm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CategorizedCompany {
	

	
	@Embeddable
	public static class Id implements Serializable { 

		@Column(name = "COMPANY_ID")
	    protected Integer companyId; 
		
		@Column(name = "CATEGORY_ID")
	    protected Integer categoryId;
		
	    public Id() {
	    	
	    }
	    
	    public Id(Integer companyId, Integer categoryId) {
	            this.companyId = categoryId;
	            this.categoryId = categoryId;
	    }
	}
	
	@EmbeddedId
	protected Id id = new Id();
	
	@ManyToOne 
	@JoinColumn(name = "CATEGORY_ID",insertable = false, updatable = false)
	protected Category categorie;
		
	@ManyToOne
	@JoinColumn(name = "COMPANY_ID",insertable = false, updatable = false)
	protected Company company;
	
	
	
	public CategorizedCompany() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorizedCompany(Category categorie, Company company) {
		super();

		this.categorie = categorie;
		this.company = company;
		this.id.categoryId= categorie.getId();
		this.id.companyId=company.getId();
		categorie.getCategorizedCompany().add(this);
		company.getCategorizedCompanies().add(this);

	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "CategorizedCompany [id=" + id + ", category=" + categorie + ", company=" + company + "]";
	}
	
}
