package com.trafalgarcp.crm.dto;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.trafalgarcp.crm.constraints.EqualEmailParameters;

public class Userdto {
	
    @NotNull
    @Size(min=2, max=30)
	private String firstname;
    
    @NotNull
    @Size(min=2, max=30)
	private String lastname;
    
    @NotNull
    @Size(min=2, max=30)
	private String username;
    
    @Email
	private String email;
	private String password;
	private String matchinpassword;
	

	
	@EqualEmailParameters
	public Userdto(String firstname, String lastname, String username, String email, String password,
			String matchinpassword) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.matchinpassword = matchinpassword;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMatchinpassword() {
		return matchinpassword;
	}
	public void setMatchinpassword(String matchinpassword) {
		this.matchinpassword = matchinpassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Userdto [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", email="
				+ email + ", password=" + password + ", matchinpassword=" + matchinpassword + "]";
	}
	
	public void  pt () {
		System.out.println(this.firstname+this.lastname+this.username);
	}
	
}
