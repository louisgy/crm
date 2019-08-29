package com.trafalgarcp.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trafalgarcp.crm.domain.User;

@Repository
public interface UserRepositoryAlt extends JpaRepository<User, Integer> {
	 User findByEmail(String email);
}
