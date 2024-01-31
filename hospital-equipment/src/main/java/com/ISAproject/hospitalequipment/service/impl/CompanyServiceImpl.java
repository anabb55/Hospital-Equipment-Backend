package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.repository.CompanyRepo;
import com.ISAproject.hospitalequipment.service.AddressService;
import com.ISAproject.hospitalequipment.service.CompanyAdministratorService;
import com.ISAproject.hospitalequipment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CompanyAdministratorService adminService;



    public List<Company> getAll(){
        return companyRepo.findAll();
    }
    public Company save(Company company){

        for (CompanyAdministrator admin :company.getAdministrators()) {
            admin.setCompany(company);
            company.getAdministrators().add(admin);
        }

        return companyRepo.save(company);
    }


    public List<Company> getByAdministrator(int id){
        return companyRepo.findCompaniesByAdministrators(id);
    }

    public Company update(Company company, Long id){
        Company old = companyRepo.findById(id).get();

        if (old !=null ) {

            old.setName(company.getName());
            addressService.update(company.getAddress());
            old.setDescription(company.getDescription());

            return companyRepo.save(old);
        } else {
            return null;
        }

    }

    public List<Company> findCompaniesByEquipment(Long equipmentId){
        return companyRepo.findCompaniesByEquipment(equipmentId);
    }

   public List<Company> findByNameContainingIgnoreCaseOrAddressCityContainingIgnoreCase(String name, String city){
        return companyRepo.findByNameContainingIgnoreCaseOrAddressCityContainingIgnoreCase(name, city);
    }
    public List<Equipment> getEquipmentByCompanyId(Long companyId) {
        return companyRepo.findEquipmentByCompanyId(companyId);
    }

    public List<Company> findByRate(Integer rate){
        return  companyRepo.findByGrade(rate);
    }



    public Company getById(Long id){
        return companyRepo.findById(id).get();
    }

    public List<Equipment> findEquipmentByCompanyIdAndName(Long companyId,String name){
     return  companyRepo.findEquipmentByCompanyIdAndName(companyId,name);
    }
}
