package com.trafalgarcp.crm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.trafalgarcp.crm.domain.Address;
import com.trafalgarcp.crm.domain.Professional;

@Repository
public interface ProfessionalRepository extends CrudRepository<Professional, Integer>{
	List<Professional> findByCompanyId(Integer id); 

}
