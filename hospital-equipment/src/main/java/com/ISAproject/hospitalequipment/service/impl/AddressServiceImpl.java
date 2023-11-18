package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.repository.AddressRepo;
import com.ISAproject.hospitalequipment.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    public AddressRepo addressRepo;
    public Address update(Address address){
        return addressRepo.save(address);
    }
}
