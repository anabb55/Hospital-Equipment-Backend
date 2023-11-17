package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.CompanyProfile;

import java.util.List;

public interface CompanyProfileService {
    CompanyProfile save(CompanyProfile company);

    public List<CompanyProfile> getAll();

}
