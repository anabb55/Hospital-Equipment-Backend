package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.Model.CompanyProfile;
import com.ISAproject.hospitalequipment.repository.CompanyProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/companyProfile")
public class CompanyProfileController {

    @Autowired
    private CompanyProfileRepo companyProfileRepo;

    @GetMapping("/")
    public List<CompanyProfile> getAllCompanyProfiles(){
        return companyProfileRepo.findAll();
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCompanyProfile(@RequestBody CompanyProfile companyProfile){
        companyProfileRepo.save(companyProfile);
    }

}
