package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.service.CompanyAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@RestController
@RequestMapping("/api/companyAdministrators")
public class CompanyAdministratorController {

    @Autowired
    private CompanyAdministratorService companyAdministratorService;

    /*
    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyAdministrator>> getAll(){
        List<CompanyAdministrator> administrators= companyAdministratorService.findAll();

        return new ResponseEntity<>(administrators, HttpStatus.OK);
    }
*/
    @PostMapping("/save")
    public ResponseEntity<CompanyAdministrator> createAdministrator(@RequestBody CompanyAdministrator administrator) {
        CompanyAdministrator createdAdministrator = companyAdministratorService.save(administrator);
        return new ResponseEntity<>(createdAdministrator, HttpStatus.CREATED);
    }


}
