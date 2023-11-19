package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.domain.Equipment;

import java.util.List;

public interface CompanyProfileService {
    CompanyProfile save(CompanyProfile company);

    public List<CompanyProfile> getAll();

    List<CompanyProfile> findCompanyProfilesByEquipment(Equipment equipment);

    List<CompanyProfile> findByNameContainingIgnoreCaseOrAddressCityContainingIgnoreCase(String name, String city);

    List<CompanyProfile> findByRate(Integer rate);

}
