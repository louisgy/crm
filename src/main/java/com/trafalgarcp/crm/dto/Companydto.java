package com.trafalgarcp.crm.dto;

public class Companydto {
	private int id;
	private String name;
	private String categorie;
	private String subcategorie;
	private String acquisition;
	private String lov;
	
	private String country;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(String acquisition) {
		this.acquisition = acquisition;
	}

	public String getLov() {
		return lov;
	}

	public void setLov(String lov) {
		this.lov = lov;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

}
