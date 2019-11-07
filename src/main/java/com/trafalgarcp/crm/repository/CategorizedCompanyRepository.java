package com.trafalgarcp.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trafalgarcp.crm.domain.CategorizedCompany;
import com.trafalgarcp.crm.domain.CategorizedCompany.Id;
import com.trafalgarcp.crm.domain.Category;
import com.trafalgarcp.crm.domain.Company;
import com.trafalgarcp.crm.domain.Industry;

public interface CategorizedCompanyRepository extends JpaRepository<CategorizedCompany,Id>{
	
	List<CategorizedCompany> findByCompanyId(Integer companyId);
//	Query("")
//	List<Category> findCategoryOfCompanies();
}
