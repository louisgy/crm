package com.trafalgarcp.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trafalgarcp.crm.domain.Industry;

public interface IndustryRepository extends JpaRepository<Industry,Integer>{
	
	@Query(value="select distinct category from industry",nativeQuery=true)
	List <String> findDistinctCategory();
	
	@Query(value="select distinct subcategory from industry",nativeQuery=true)
	List <String> findDistinctSubcategory();
	

}
