package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/getAll")
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @PostMapping(value = "/save")
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }
}