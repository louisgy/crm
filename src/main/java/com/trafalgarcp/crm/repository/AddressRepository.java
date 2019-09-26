package com.trafalgarcp.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trafalgarcp.crm.domain.Address;
import com.trafalgarcp.crm.domain.Company;

public interface AddressRepository extends JpaRepository<Address,Integer>{
	List<Address> findByCompanyId(Integer id); 

}
