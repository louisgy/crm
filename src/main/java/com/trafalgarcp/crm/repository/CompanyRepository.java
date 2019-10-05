package com.trafalgarcp.crm.repository;


//import org.springframework.stereotype.Repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

import com.trafalgarcp.crm.domain.Company;
import java.util.*;

public interface CompanyRepository extends CrudRepository<Company,Integer>{	
	//Company findById(Integer id);
	
	List<Company> findAll();
	
	@Query("SELECT company FROM Company company left join fetch company.addresses WHERE company.id =:id")
	@Transactional(readOnly = true)
	Optional<Company> findById(@Param("id") Integer id);
	

//	@Query("UPDATE Company c SET c.name=:name WHERE c.id= : id")
//	void update(@Param("id") Integer  id,@Param("name") String name);
	
//	void customSave (Company company);
}
