package com.trafalgarcp.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trafalgarcp.crm.domain.Address;
import com.trafalgarcp.crm.exception.ResourceNotFoundException;
import com.trafalgarcp.crm.repository.AddressRepository;
import com.trafalgarcp.crm.repository.CompanyRepository;
  
@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CompanyRepository companyRepository;
	
	
	
	@Override
	public Address save(Address address,Integer companyId) {
		return  companyRepository.findById(companyId).map(company ->{
			address.setCompany(company);
			return addressRepository.save(address );
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + companyId + " not found"));
	}



	@Override
	public Address findAddressById(Integer id) {
		return  addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address " + id + " not found"));
	}
 

}
