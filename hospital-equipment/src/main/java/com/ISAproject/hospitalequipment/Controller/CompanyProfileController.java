package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.repository.CompanyProfileRepo;
import com.ISAproject.hospitalequipment.service.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/companyProfile")
public class CompanyProfileController {

    @Autowired
    private CompanyProfileRepo companyProfileRepo;
    @Autowired
    private CompanyProfileService companyProfileService;

    @GetMapping(value="/")
    public List<CompanyProfile> getAllCompanyProfiles(){
        return companyProfileRepo.findAll();
    }


    @PostMapping("/save")
    public ResponseEntity<CompanyProfile> saveCompanyProfile(@RequestBody CompanyProfile companyProfile) {
        CompanyProfile createdCompany = companyProfileService.save(companyProfile);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }



}
