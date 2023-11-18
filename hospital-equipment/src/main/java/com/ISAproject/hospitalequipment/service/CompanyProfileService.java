package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.domain.Equipment;

import java.util.List;

public interface CompanyProfileService {
    CompanyProfile save(CompanyProfile company);

    public List<CompanyProfile> getAll();


    public List<CompanyProfile> getByAdministrator(int id);

    public CompanyProfile update(CompanyProfile company,Long id);

    List<CompanyProfile> findCompanyProfilesByEquipment(Equipment equipment);

}
