package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.repository.CompanyAdministratorRepo;
import com.ISAproject.hospitalequipment.repository.CompanyProfileRepo;
import com.ISAproject.hospitalequipment.service.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyProfileServiceImpl  implements CompanyProfileService {
    @Autowired
    private CompanyProfileRepo companyProfileRepo;


    public CompanyProfile save(CompanyProfile companyProfile){
        return companyProfileRepo.save(companyProfile);
    }

}
