package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.repository.AddressRepo;
import com.ISAproject.hospitalequipment.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public List<Address> findAll() {
        return addressRepo.findAll();
    }
    public Address save(Address address){
        return addressRepo.save(address);
    }
}
