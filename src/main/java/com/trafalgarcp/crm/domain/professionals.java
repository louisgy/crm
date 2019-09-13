package com.trafalgarcp.crm.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Professionals {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

		private String phone;
		private String fax;
	
		
	    
		public Professionals() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


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


		public String getPhone() {
			return phone;
		}


		public void setPhone(String phone) {
			this.phone = phone;
		}


		public String getFax() {
			return fax;
		}


		public void setFax(String fax) {
			this.fax = fax;
		}




		

}
