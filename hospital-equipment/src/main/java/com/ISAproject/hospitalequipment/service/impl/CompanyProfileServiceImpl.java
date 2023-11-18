package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.repository.CompanyAdministratorRepo;
import com.ISAproject.hospitalequipment.repository.CompanyProfileRepo;
import com.ISAproject.hospitalequipment.service.AddressService;
import com.ISAproject.hospitalequipment.service.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyProfileServiceImpl  implements CompanyProfileService {
    @Autowired
    private CompanyProfileRepo companyProfileRepo;

    @Autowired
    private AddressService addressService;

    public List<CompanyProfile> getAll(){
        return companyProfileRepo.findAll();
    }
    public CompanyProfile save(CompanyProfile companyProfile){
        return companyProfileRepo.save(companyProfile);
    }

    public List<CompanyProfile> getByAdministrator(int id){
        return companyProfileRepo.findCompanyProfilesByAdministrators(id);
    }

    public CompanyProfile update(CompanyProfile company,Long id){
        CompanyProfile old = companyProfileRepo.findById(id).get();

        if (old !=null ) {

            old.setName(company.getName());
            addressService.update(company.getAddress());
            old.setDescription(company.getDescription());

            return companyProfileRepo.save(old);
        } else {
            return null;
        }

    }

}
