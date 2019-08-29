package com.trafalgarcp.crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import com.trafalgarcp.crm.domain.User;
import com.trafalgarcp.crm.dto.Userdto;
import com.trafalgarcp.crm.repository.UserRepository;

//@Transactional
@Service
public class  UserserviceImpl  implements Userservice {

	@Autowired
	private UserRepository userRepository;
	


	@Override
	public User signupUser(Userdto dto) {
		System.out.println("UUUUUUUUUU"+dto.getFirstname());
		System.out.println("UUUUUUUUUU"+dto.getLastname());
		System.out.println("UUUUUUUUUU"+dto.getEmail());
		System.out.println("UUUUUUUUUU"+dto.getPassword());
		System.out.println("UUUUUUUUUU"+dto.getUsername());
		
		User user = new User();
		user.setFirstname(dto.getFirstname());
		user.setLastname(dto.getLastname());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setUsername(dto.getUsername());
		
		return userRepository.save(user);
	}

	
	@Override
	public boolean isEmailAlreadyUsed(String email) {
		List<User > userlist = userRepository.findByEmail(email);
		if (userlist.size() > 0 ) // Email not yet used
			return true;
		else 
		return false;
	}



	@Override
	public boolean isUsernameAlreadyUsed(String username) {
		
		List<User > userlist = userRepository.findByUsername(username);
		if (userlist.size() > 0 ) // Email not yet used
			return true;
		else 
		return false;
	}


	@Override
	public User findMyUserById(Integer id) {
		User user = userRepository.findById(id).orElse(new User());
		System.out.println("\n"+"------------------"+id+user.getFirstname()+"\n");
		return (user);

	}


	@Override
	public boolean save(User user) {
		userRepository.save(user);
		return false;
	}


	@Override
	public User findByEmail(String email) {
		return (userRepository.findByEmail(email).get(0));
	}


	
	
	
	



	

	
}