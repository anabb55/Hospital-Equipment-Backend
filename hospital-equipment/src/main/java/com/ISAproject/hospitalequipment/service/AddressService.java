package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Address;

import java.util.List;


public interface AddressService {
    public List<Address> findAll();
    Address save(Address address);
}
