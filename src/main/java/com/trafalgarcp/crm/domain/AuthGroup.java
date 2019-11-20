package com.trafalgarcp.crm.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthGroup {
	@Id
	private Integer id;
	private String username;
	private String authGroup;
	
	public long getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthGroup() {
		return authGroup;
	}
	public void setAuthGroup(String authGroup) {
		this.authGroup = authGroup;
	}
	
	

}
