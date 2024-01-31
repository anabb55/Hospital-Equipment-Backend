package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.LoyaltyProgram;
import com.ISAproject.hospitalequipment.dto.AddressDTO;
import com.ISAproject.hospitalequipment.dto.LoyaltyProgramDTO;
import com.ISAproject.hospitalequipment.service.AddressService;
import com.ISAproject.hospitalequipment.service.impl.AddressServiceImpl;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;




    @GetMapping("/getAll")
    public List<Address> findAll() {

        return addressService.findAll();
    }


    @PostMapping(value = "/save")
    public ResponseEntity<AddressDTO> save(@RequestBody AddressDTO address) {
        Address addres = new Address();
        addres.setId(address.getId());
        addres.setCountry(address.getCountry());
        addres.setNumber(address.getNumber());
        addres.setStreet(address.getStreet());
        addres.setLatitude(0.0);
        addres.setLongitude(0.0);
        addres.setCity(address.getCity());
        addressService.save(addres);
        return new ResponseEntity<>(new AddressDTO(addres), HttpStatus.OK) ;
    }
}