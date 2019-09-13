package com.trafalgarcp.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trafalgarcp.crm.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer>{	
	
}
