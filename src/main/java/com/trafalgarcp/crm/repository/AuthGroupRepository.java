package com.trafalgarcp.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trafalgarcp.crm.domain.AuthGroup;



public interface AuthGroupRepository extends  JpaRepository<AuthGroup,Integer>{
   List<AuthGroup> findByUsername(String username);
}
