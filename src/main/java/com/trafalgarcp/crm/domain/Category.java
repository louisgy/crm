package com.trafalgarcp.crm.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;


@TableGenerator(name="Categor_Gen",
table="ID_GEN",
pkColumnName="GEN_NAME",
valueColumnName="GEN_VAL",
pkColumnValue="categor_Gen",
initialValue=500,
allocationSize=60)
@Entity
public class Category {
	
	@Id @GeneratedValue(generator="Categor_Gen")
	private Integer id;
	private String categorie;
	private String subcategorie;
	
	
	@OneToMany(mappedBy = "categorie")
    protected Set<CategorizedCompany> categorizedCompany = new HashSet<>();
	
	

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String categorie, String subcategorie) {
		super();
		this.categorie = categorie;
		this.subcategorie = subcategorie;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

   



	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getSubcategorie() {
		return subcategorie;
	}

	public void setSubcategorie(String subcategorie) {
		this.subcategorie = subcategorie;
	}
	

	public Set<CategorizedCompany> getCategorizedCompany() {
		return categorizedCompany;
	}

	public void setCategorizedCompany(Set<CategorizedCompany> categorizedCompany) {
		this.categorizedCompany = categorizedCompany;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + categorie + ", subcategory=" + subcategorie
				+ ", categorizedCompany=" + categorizedCompany + "]";
	}
			
}
