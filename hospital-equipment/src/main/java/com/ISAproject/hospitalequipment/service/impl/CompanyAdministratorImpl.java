package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.repository.CompanyAdministratorRepo;
import com.ISAproject.hospitalequipment.service.CompanyAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyAdministratorImpl implements CompanyAdministratorService {
    @Autowired
    private CompanyAdministratorRepo companyAdministratorRepo;

    public List<CompanyAdministrator> findAll(){
        return companyAdministratorRepo.findAll();
    }

    /*
    public List<CompanyAdministrator> findByCompany(CompanyProfile company){
        return companyAdministratorRepo.findByCompany(company);
    }

     */
}
