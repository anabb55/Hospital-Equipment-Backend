package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.repository.CompanyAdministratorRepo;
import com.ISAproject.hospitalequipment.service.AddressService;
import com.ISAproject.hospitalequipment.service.CompanyAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyAdministratorImpl implements CompanyAdministratorService {
    @Autowired
    private CompanyAdministratorRepo companyAdministratorRepo;

    //pazi na ovo=>izmjeni kasnije=> krsis pravila=> referenciranje drugog servisa
    @Autowired
    private AddressService addressService;
    public List<CompanyAdministrator> findAll(){
        return companyAdministratorRepo.findAll();
    }

    public CompanyAdministrator save(CompanyAdministrator admin){return companyAdministratorRepo.save(admin);}

    public CompanyAdministrator getById(Long id){return companyAdministratorRepo.findById(id).get();}

    public CompanyAdministrator update(CompanyAdministrator admin, Long id){
        CompanyAdministrator old= companyAdministratorRepo.findById(id).get();

        if(old!=null){
            old.setFirstName(admin.getFirstName());
            old.setLastName(admin.getLastName());
            old.setEmail(admin.getEmail());
            old.setOccupation(admin.getOccupation());
            old.setPhoneNumber(admin.getPhoneNumber());
            old.setPassword(admin.getPassword());
            addressService.update(admin.getAddress());
            return companyAdministratorRepo.save(old);
        }else{
            return null;
        }
    }
}
