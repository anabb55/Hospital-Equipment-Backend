package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.repository.CompanyAdministratorRepo;
import com.ISAproject.hospitalequipment.repository.CompanyProfileRepo;
import com.ISAproject.hospitalequipment.service.CompanyProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyProfileServiceImpl  implements CompanyProfileService {
    @Autowired
    private CompanyProfileRepo companyProfileRepo;

    public List<CompanyProfile> getAll(){
        return companyProfileRepo.findAll();
    }
    public CompanyProfile save(CompanyProfile companyProfile){
        return companyProfileRepo.save(companyProfile);
    }

    public List<CompanyProfile> findCompanyProfilesByEquipment(Equipment equipment){
        return companyProfileRepo.findCompanyProfilesByEquipment(equipment);
    }
   public List<CompanyProfile> findByNameContainingIgnoreCaseOrAddressCityContainingIgnoreCase(String name, String city){
        return companyProfileRepo.findByNameContainingIgnoreCaseOrAddressCityContainingIgnoreCase(name, city);
    }

    public List<CompanyProfile> findByRate(Integer rate){
        return  companyProfileRepo.findByGrade(rate);
    }


}
