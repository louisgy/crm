package com.trafalgarcp.crm.services;

import com.trafalgarcp.crm.domain.User;
import com.trafalgarcp.crm.dto.Userdto;

public interface Userservice {
	public User signupUser(Userdto userdto);
	public boolean isEmailAlreadyUsed (String email);
	public boolean isUsernameAlreadyUsed (String unsername);
	public User findMyUserById(Integer id);
	//public boolean updateUserProfile(User user);
	public boolean save(User user);
	public User findByEmail(String email);
//	public User findById(Integer i);

}
