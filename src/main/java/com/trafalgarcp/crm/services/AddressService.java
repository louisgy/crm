package com.trafalgarcp.crm.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.trafalgarcp.crm.domain.Address;
import com.trafalgarcp.crm.repository.AddressRepository;

public interface AddressService {
	
	
	public Address save(Address address,Integer companyId);
	
	public Address findAddressById(Integer id);
}
