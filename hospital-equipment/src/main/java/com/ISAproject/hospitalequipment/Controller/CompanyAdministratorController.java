package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.dto.CompanyAdministratorDTO;
import com.ISAproject.hospitalequipment.dto.LocationDTO;
import com.ISAproject.hospitalequipment.service.CompanyAdministratorService;
import com.ISAproject.hospitalequipment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/companyAdministrators")
public class CompanyAdministratorController {

    @Autowired
    private CompanyAdministratorService companyAdministratorService;
    @Autowired
    private CompanyService companyService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyAdministratorDTO>> getAll(){
        List<CompanyAdministrator> administrators= companyAdministratorService.findAll();

        List<CompanyAdministratorDTO> companyAdministratorDTOs = new ArrayList<>();

        for (CompanyAdministrator s : administrators) {
            companyAdministratorDTOs.add(new CompanyAdministratorDTO(s));
        }

        return new ResponseEntity<>(companyAdministratorDTOs, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/save")
    public ResponseEntity<CompanyAdministratorDTO> createAdministrator(@RequestBody CompanyAdministratorDTO administrator) {

        CompanyAdministrator admin  = new CompanyAdministrator();
        admin.setId(administrator.getId());


        admin.setEmail(administrator.getEmail());
        admin.setPassword(administrator.getPassword());
        admin.setOccupation(administrator.getOccupation());
        admin.setFirstname(administrator.getFirstname());
        admin.setLastname(administrator.getLastname());
        admin.setPhoneNumber(administrator.getPhoneNumber());
        admin.setUsername(administrator.getUsername());
        admin.setRoles(administrator.getRoles());
        Address address = new Address();
            address.setId(administrator.getAddress().getId());
            address.setCity(administrator.getAddress().getCity());
            address.setCountry(administrator.getAddress().getCountry());
            address.setStreet(administrator.getAddress().getStreet());
            address.setNumber(administrator.getAddress().getNumber());
        admin.setAddress(address);
        CompanyAdministrator createdAdministrator = companyAdministratorService.save(admin);

        if (createdAdministrator == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CompanyAdministratorDTO(createdAdministrator), HttpStatus.OK);
    }
//    @GetMapping("/combineLocations/{adminId}")
//    public ResponseEntity<List<Object[]>> getCombinedLocationData(@PathVariable Long adminId) {
//        try {
//            List<Object[]> combinedData = companyAdministratorService.combineLocationData(adminId);
//            if (combinedData.isEmpty()) {
//                return ResponseEntity.noContent().build();
//            }
//            return ResponseEntity.ok(combinedData);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
@GetMapping("/createLocationList/{adminId}")
public ResponseEntity<List<LocationDTO>> getLocations(@PathVariable Long adminId) {
    try {
        List<LocationDTO> locations = companyAdministratorService.createLocationList(adminId);
        return ResponseEntity.ok(locations);
    } catch (Exception e) {
        return ResponseEntity.internalServerError().build();
    }
}
    @CrossOrigin(origins = "*")

    @GetMapping("/getById/{id}")
    public ResponseEntity<CompanyAdministratorDTO> getCompany(@PathVariable Long id) {

        CompanyAdministrator companyA = companyAdministratorService.getById(id);

        if (companyA == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CompanyAdministratorDTO(companyA), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyAdministratorDTO> update(@PathVariable("id") Long id, @RequestBody CompanyAdministratorDTO administrator) {

        CompanyAdministrator companyAdministrator  = new CompanyAdministrator();
        companyAdministrator.setId(administrator.getId());
        companyAdministrator.setEmail(administrator.getEmail());
        companyAdministrator.setUsername(administrator.getUsername());
        companyAdministrator.setPassword(administrator.getPassword());
        companyAdministrator.setOccupation(administrator.getOccupation());
        companyAdministrator.setFirstname(administrator.getFirstname());
        companyAdministrator.setLastname(administrator.getLastname());
        companyAdministrator.setPhoneNumber(administrator.getPhoneNumber());
            Address address = new Address();
            address.setId(administrator.getAddress().getId());
            address.setCity(administrator.getAddress().getCity());
            address.setCountry(administrator.getAddress().getCountry());
            address.setStreet(administrator.getAddress().getStreet());
            address.setNumber(administrator.getAddress().getNumber());
        companyAdministrator.setAddress(address);

       // Company company = companyService.getById(administrator.getCompany().getId());
        //company.setWorkEndTime(administrator.getCompany().getWorkEndTime());
        //company.setWorkStartTime(administrator.getCompany().getWorkStartTime());
        //company.setName(administrator.getCompany().getName());
        //company.setId(administrator.getCompany().getId());
        //company.setGrade(administrator.getCompany().getGrade());
        //company.setDescription(administrator.getCompany().getDescription());
        //company.setEquipmentStocks(administrator.getCompany().get());

       // companyAdministrator.setCompany(company);

        Company company= new Company();
        company.setId(administrator.getCompany().getId());
        company.setWorkEndTime(administrator.getCompany().getWorkEndTime());
        company.setWorkStartTime(administrator.getCompany().getWorkStartTime());
        company.setName(administrator.getCompany().getName());
        company.setId(administrator.getCompany().getId());
        company.setGrade(administrator.getCompany().getGrade());
        company.setDescription(administrator.getCompany().getDescription());


         companyAdministrator.setCompany(company);

        CompanyAdministrator updatedAdmin = companyAdministratorService.update(companyAdministrator, id);

        if (updatedAdmin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CompanyAdministratorDTO(updatedAdmin), HttpStatus.OK);

    }

}
