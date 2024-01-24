package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getAll")
    public ResponseEntity<List<Address>> findAll() {

        List<Address> addresses= addressService.findAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @PostMapping("/save")
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }
}