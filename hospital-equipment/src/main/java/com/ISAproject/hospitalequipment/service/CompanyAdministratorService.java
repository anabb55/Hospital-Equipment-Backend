package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.dto.LocationDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CompanyAdministratorService {
    public List<CompanyAdministrator> findAll();
    public CompanyAdministrator save(CompanyAdministrator admin);

    public CompanyAdministrator getById(Long id);
    public List<Object[]> combineLocationData(Long adminId) ;
    public List<LocationDTO> createLocationList(Long adminId) ;
    public Object[] findCompanyLocationByAdminId(Long adminId) ;

    public CompanyAdministrator update(CompanyAdministrator admin, Long id);
    public List<CompanyAdministrator> findAvailableAdministrator(LocalTime startTime, LocalTime endTime, LocalDate date,Long companyId);
}
