package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.repository.CompanyProfileRepo;
import com.ISAproject.hospitalequipment.service.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/companyProfile")
public class CompanyProfileController {

    @Autowired
    private CompanyProfileService companyProfileService;

    @GetMapping("/")
    public List<CompanyProfile> getAllCompanyProfiles(){
        return companyProfileService.getAll();
    }





}
