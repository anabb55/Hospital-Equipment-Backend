package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.Equipment;

import java.util.List;

public interface CompanyService {
    Company save(Company company);

    public List<Company> getAll();


    public List<Company> getByAdministrator(int id);

    public Company update(Company company, Long id);

    /*
    List<Company> findCompanyProfilesByEquipment(Equipment equipment);
*/
    List<Company> findByNameContainingIgnoreCaseOrAddressCityContainingIgnoreCase(String name, String city);

    List<Company> findByRate(Integer rate);

    public Company getById(Long id);
}
