package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CompanyAdministratorService {
    public List<CompanyAdministrator> findAll();
    public CompanyAdministrator save(CompanyAdministrator admin);

    public CompanyAdministrator getById(Long id);

    public CompanyAdministrator update(CompanyAdministrator admin, Long id);
    public List<CompanyAdministrator> findAllAdministratorsByCompanyId(Long companyId);
    public List<CompanyAdministrator> findAvailableAdministrator(LocalTime startTime, LocalTime endTime, LocalDate date,Long companyId);
}
