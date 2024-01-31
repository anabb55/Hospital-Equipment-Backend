package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Address;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    private final Logger LOG = LoggerFactory.getLogger(AddressController.class);

    @GetMapping("/getAll")

    public List<Address> findAll() {

        return addressService.findAll();
    }

    public ResponseEntity<List<Address>> anaFallback(RequestNotPermitted rnp) {
        LOG.warn("Prevazidjen broj poziva u ogranicenom vremenskom intervalu");
        System.out.println("Usao sam ovde");
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();

    }


    @PostMapping("/save")
    @RateLimiter(name = "ana", fallbackMethod = "anaFallback")
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }
}