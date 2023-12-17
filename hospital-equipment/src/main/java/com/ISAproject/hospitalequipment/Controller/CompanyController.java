package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.dto.CompanyDTO;
import com.ISAproject.hospitalequipment.dto.RegisterUserDTO;
import com.ISAproject.hospitalequipment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/companyProfile")
public class CompanyController {
    @Autowired

    private CompanyService companyService;

    @GetMapping("/")


    public ResponseEntity<List<CompanyDTO>> getAllCompanyProfiles(){
        List<Company>companies=companyService.getAll();
        List<CompanyDTO> companyDTOs = new ArrayList<>();

        for (Company s : companies) {
            companyDTOs.add(new CompanyDTO(s));
        }

        return new ResponseEntity<>(companyDTOs, HttpStatus.OK);


    }



    @PostMapping("/save")
    public ResponseEntity<CompanyDTO> saveCompanyProfile(@RequestBody CompanyDTO companyDto) {
        Company company = new Company();
        company.setId(companyDto.getId());

        Address address = new Address();
        address.setId(companyDto.getAddress().getId());
        address.setCity(companyDto.getAddress().getCity());
        address.setCountry(companyDto.getAddress().getCountry());
        address.setStreet(companyDto.getAddress().getStreet());
        address.setNumber(companyDto.getAddress().getNumber());

        company.setAddress(address);
        company.setDescription(companyDto.getDescription());
        company.setName(companyDto.getName());
        company.setGrade(companyDto.getGrade());
        company.setWorkStartTime(companyDto.getWorkStartTime());
        company.setWorkEndTime(companyDto.getWorkEndTime());

        Company createdCompany = companyService.save(company);

        if (createdCompany == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CompanyDTO(company), HttpStatus.OK);    }


    @GetMapping("/byAdmin/{id}")
    public ResponseEntity<List<CompanyDTO>> getByAdministrator(@PathVariable int id){
        List<Company> companies= companyService.getByAdministrator(id);
        List<CompanyDTO> companyDTOs = new ArrayList<>();

        for (Company s : companies) {
            companyDTOs.add(new CompanyDTO(s));
        }

        return new ResponseEntity<>(companyDTOs, HttpStatus.OK);
    }

    @GetMapping("/byEquipment/{equipmentId}")
    public List<Company> getByEquipment(@PathVariable Long equipmentId){
        List<Company> companies= companyService.findCompaniesByEquipment(equipmentId);
        return companies;
    }



    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyDTO> update(@PathVariable Long id, @RequestBody Company company) {
        Company updatedCompany = companyService.update(company, id);
        if (updatedCompany == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CompanyDTO(updatedCompany), HttpStatus.OK);

    }



    /*
    @GetMapping("/getCompanyProfilesByEquipment")
    public List<Company> findCompanyProfilesByEquipment(Equipment e){
        return companyService.findCompanyProfilesByEquipment(e);

    }
    */


    @GetMapping("/getById/{id}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable Long id) {

        Company company = companyService.getById(id);

        if (company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CompanyDTO(company), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Company>> searchCompanies(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "city", required = false) String city) {

        List<Company> companies = companyService.findByNameContainingIgnoreCaseOrAddressCityContainingIgnoreCase(name, city);

        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/searchByRating")
    public ResponseEntity<List<Company>> searchCompaniesByRating(
            @RequestParam(name = "grade", required = false) Integer rate) {

        List<Company> companies = companyService.findByRate(rate);

        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/company/{companyId}/equipment")
    public List<Equipment> getEquipmentByCompanyId(@PathVariable Long companyId) {
        return companyService.getEquipmentByCompanyId(companyId);
    }

    @GetMapping("/equipment/{companyId}/search")
    public ResponseEntity<List<Equipment>> searchEquipmentByCompanyIdAndName(
            @PathVariable Long companyId,
            @RequestParam String name) {
        List<Equipment> equipmentList = companyService.findEquipmentByCompanyIdAndName(companyId, name);
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }


}
