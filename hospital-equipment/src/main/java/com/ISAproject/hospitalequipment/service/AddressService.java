package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Address;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

import java.util.List;


public interface AddressService {
    @RateLimiter(name = "ana", fallbackMethod = "standardFallback")
    public List<Address> findAll();
    public Address save(Address address);
    public Address update(Address address);

}