package com.trafalgarcp.crm.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@TableGenerator(name="Prof_Gen",
table="ID_GEN",
pkColumnName="GEN_NAME",
valueColumnName="GEN_VAL",
pkColumnValue="profs_Gen",
initialValue=50000,
allocationSize=60)
@Entity
public class Professional {

	    @Id @GeneratedValue(generator="Prof_Gen")
		private Integer id;
	    
	    
//	    @Size(min = 3, max = 15,message="not less than 3 or more than 15")
	    @NotBlank
		private String firstname;
	
	    @NotBlank
		private String lastname;
	    @NotBlank
		private String title;
	    @NotBlank
		@Email(message ="Email should be valid")
		private String email;
	    
	    @ManyToOne(
				fetch = FetchType.LAZY
				)
		@JoinColumn(name="companyId",nullable=false)
		private Company company; 

		private String primaryPhone ;
		private String secondaryPhone;
		private String fax;
		private String linkedin;
		private String relationship;
		private String comments;
	
		
	    
		public Professional() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		public void setCompany(Company company) {
			setCompany(company,true);
		}

		void setCompany(Company company, boolean add) {
			this.company=company;
			if(company!= null && add) {
				company.addProfessional(this,false);
			}
		}
		
		
		public boolean isNew() {
			return this.id == null;
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

//		public void setCompany(Company company) {
//			this.company = company;
//		}

		public String getFirstname() {
			return firstname;
		}


		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}


		public String getLastname() {
			return lastname;
		}


		public void setLastname(String lastname) {
			this.lastname = lastname;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
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


		public String getFax() {
			return fax;
		}


		public void setFax(String fax) {
			this.fax = fax;
		}


		public String getLinkedin() {
			return linkedin;
		}


		public void setLinkedin(String linkedin) {
			this.linkedin = linkedin;
		}


		public String getRelationship() {
			return relationship;
		}


		public void setRelationship(String relationship) {
			this.relationship = relationship;
		}


		public String getComments() {
			return comments;
		}


		public void setComments(String comments) {
			this.comments = comments;
		}

		


		

}
