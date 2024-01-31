package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.Controller.AddressController;
import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.repository.AddressRepo;
import com.ISAproject.hospitalequipment.service.AddressService;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     
     public Address update(Address address){
      return addressRepo.save(address);
    }
  
}
 