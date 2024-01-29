package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.dto.LocationDTO;
import com.ISAproject.hospitalequipment.repository.CompanyAdministratorRepo;
import com.ISAproject.hospitalequipment.service.AddressService;
import com.ISAproject.hospitalequipment.service.CompanyAdministratorService;
import com.ISAproject.hospitalequipment.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyAdministratorImpl implements CompanyAdministratorService {
    @Autowired
    private CompanyAdministratorRepo companyAdministratorRepo;

    //pazi na ovo=>izmjeni kasnije=> krsis pravila=> referenciranje drugog servisa
    @Autowired
    private AddressService addressService;

    @Autowired
    private ContractService contractService;
    public List<CompanyAdministrator> findAll(){
        return companyAdministratorRepo.findAll();
    }

    public CompanyAdministrator save(CompanyAdministrator admin){return companyAdministratorRepo.save(admin);}

    public CompanyAdministrator getById(Long id){return companyAdministratorRepo.findById(id).get();}

    public List<CompanyAdministrator> findAvailableAdministrator(LocalTime startTime, LocalTime endTime, LocalDate date,Long companyId){
        return companyAdministratorRepo.findAvailableAdministrator(date,startTime,endTime,companyId);
    }

    public List<Object[]> combineLocationData(Long adminId) {
        List<Object[]> combinedData = new ArrayList<>();

        Object[] companyLocation = findCompanyLocationByAdminId(adminId);
        if (companyLocation != null) {
            combinedData.add(companyLocation);
        }

        Object[] contractLocation = contractService.findLongitudeLatitudeOfLatestContract();
        if (contractLocation != null) {
            combinedData.add(contractLocation);
        }

        return combinedData;
    }

    public List<LocationDTO> createLocationList(Long adminId) {
        List<LocationDTO> locations = new ArrayList<>();

        Object[] companyLocation = findCompanyLocationByAdminId(adminId);
        if (companyLocation != null && companyLocation[0] instanceof Object[]) {
            Object[] locationData = (Object[]) companyLocation[0];
            if (locationData.length == 2) {
                double latitude = ((Number) locationData[0]).doubleValue();
                double longitude = ((Number) locationData[1]).doubleValue();
                locations.add(new LocationDTO(latitude, longitude));
            }
        }

        Object[] contractLocation = contractService.findLongitudeLatitudeOfLatestContract();
        if (contractLocation != null && contractLocation[0] instanceof Object[]) {
            Object[] locationData = (Object[]) contractLocation[0];
            if (locationData.length == 2) {
                double latitude = ((Number) locationData[0]).doubleValue();
                double longitude = ((Number) locationData[1]).doubleValue();
                locations.add(new LocationDTO(latitude, longitude));
            }
        }

        return locations;
    }






    public Object[] findCompanyLocationByAdminId(Long adminId) {
        return companyAdministratorRepo.findCompanyLocationByAdminId(adminId);
    }

    public CompanyAdministrator update(CompanyAdministrator admin, Long id){
        CompanyAdministrator old= companyAdministratorRepo.findById(id).get();

        if(old!=null){
            old.setFirstname(admin.getFirstname());
            old.setLastname(admin.getLastname());
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
