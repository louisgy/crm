package com.trafalgarcp.crm.services;

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
		user.setFirstName(dto.getFirstname());
		user.setLastName(dto.getLastname());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setUsername(dto.getUsername());
		
		return userRepository.save(user);
	}



	

	
}