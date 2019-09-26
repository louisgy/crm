package com.trafalgarcp.crm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trafalgarcp.crm.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
	List<User> findByEmail(String email);
	List<User> findByUsername(String username);
	Optional<User> findById(Integer id);
}
