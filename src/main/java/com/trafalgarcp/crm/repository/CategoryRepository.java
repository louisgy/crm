package com.trafalgarcp.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trafalgarcp.crm.domain.Category;


public interface CategoryRepository extends JpaRepository<Category,Integer> {
	
	@Query(value="select distinct categorie from category",nativeQuery=true)
	List <String> findDistinctCategorie();
	
	@Query(value="select distinct subcategorie from category",nativeQuery=true)
	List <String> findDistinctSubcategorie();   
}
