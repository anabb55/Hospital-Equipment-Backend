package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.domain.Equipment;
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

    private CompanyProfileService companyProfileService;

    @GetMapping("/")
    public List<CompanyProfile> getAllCompanyProfiles(){
        return companyProfileService.getAll();
    }


    @PostMapping("/save")
    public ResponseEntity<CompanyProfile> saveCompanyProfile(@RequestBody CompanyProfile companyProfile) {
        CompanyProfile createdCompany = companyProfileService.save(companyProfile);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }


    @GetMapping("/byAdmin/{id}")
    public ResponseEntity<List<CompanyProfile>> getByAdministrator(@PathVariable int id){
        List<CompanyProfile> companies= companyProfileService.getByAdministrator(id);
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyProfile> update(@PathVariable Long id, @RequestBody CompanyProfile company){
        CompanyProfile updatedCompany= companyProfileService.update(company,id);
        return new ResponseEntity<>(updatedCompany,HttpStatus.OK);

    @GetMapping("/getCompanyProfilesByEquipment")
    public List<CompanyProfile> findCompanyProfilesByEquipment(Equipment e){
        return companyProfileService.findCompanyProfilesByEquipment(e);

    }



}
