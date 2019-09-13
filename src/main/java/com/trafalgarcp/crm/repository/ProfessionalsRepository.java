package com.trafalgarcp.crm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trafalgarcp.crm.domain.Professionals;

@Repository
public interface ProfessionalsRepository extends CrudRepository<Professionals, Integer>{
	

}
