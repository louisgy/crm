package com.trafalgarcp.crm.services;

import com.trafalgarcp.crm.domain.User;
import com.trafalgarcp.crm.dto.Userdto;

public interface Userservice {
	public User signupUser(Userdto userdto);

}
