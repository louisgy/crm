package com.trafalgarcp.crm.domain;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;


@Entity
@TableGenerator(name = "User_Gen", 
table = "ID_GEN", pkColumnName = "GEN_NAME", 
valueColumnName = "GEN_VAL", 
pkColumnValue = "Usr_Gen", 
initialValue = 50000, 
allocationSize = 6)
public class User {
	 
	 
	@Id
	@GeneratedValue(generator = "User_Gen")
	private  Integer  id;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

    

	public User(Integer id, String firstname, String lastname, String email, String username, String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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
	

	
	
	
	
	

}
