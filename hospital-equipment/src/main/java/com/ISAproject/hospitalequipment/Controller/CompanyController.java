package com.ISAproject.hospitalequipment.Controller;

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
    @CrossOrigin(origins = "*")

    @GetMapping("/")


    public ResponseEntity<List<CompanyDTO>> getAllCompanyProfiles(){
        List<Company>companies=companyService.getAll();
        List<CompanyDTO> companyDTOs = new ArrayList<>();

        for (Company s : companies) {
            companyDTOs.add(new CompanyDTO(s));
        }

        return new ResponseEntity<>(companyDTOs, HttpStatus.OK);


    }


    @CrossOrigin(origins = "*")

    @PostMapping("/save")

    public ResponseEntity<Company> saveCompanyProfile(@RequestBody Company company) {
        Company createdCompany = companyService.save(company);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")

    @GetMapping("/byAdmin/{id}")
    public ResponseEntity<List<Company>> getByAdministrator(@PathVariable int id){
        List<Company> companies= companyService.getByAdministrator(id);
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }

    @GetMapping("/byEquipment/{equipmentId}")
    public List<Company> getByEquipment(@PathVariable Long equipmentId){
        List<Company> companies= companyService.findCompaniesByEquipment(equipmentId);
        return companies;
    }



    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Company> update(@PathVariable Long id, @RequestBody Company company) {
        Company updatedCompany = companyService.update(company, id);
        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);

    }



    /*
    @GetMapping("/getCompanyProfilesByEquipment")
    public List<Company> findCompanyProfilesByEquipment(Equipment e){
        return companyService.findCompanyProfilesByEquipment(e);

    }
    */

    @CrossOrigin(origins = "*")

    @GetMapping("/getById/{id}")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable Long id) {

        Company company = companyService.getById(id);

        if (company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CompanyDTO(company), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")

    @GetMapping("/search")
    public ResponseEntity<List<Company>> searchCompanies(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "city", required = false) String city) {

        List<Company> companies = companyService.findByNameContainingIgnoreCaseOrAddressCityContainingIgnoreCase(name, city);

        return new ResponseEntity<>(companies, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")

    @GetMapping("/searchByRating")
    public ResponseEntity<List<Company>> searchCompaniesByRating(
            @RequestParam(name = "grade", required = false) Integer rate) {

        List<Company> companies = companyService.findByRate(rate);

        return new ResponseEntity<>(companies, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")

    @GetMapping("/company/{companyId}/equipment")
    public List<Equipment> getEquipmentByCompanyId(@PathVariable Long companyId) {
        return companyService.getEquipmentByCompanyId(companyId);
    }
    @CrossOrigin(origins = "*")

    @GetMapping("/equipment/{companyId}/search")
    public ResponseEntity<List<Equipment>> searchEquipmentByCompanyIdAndName(
            @PathVariable Long companyId,
            @RequestParam String name) {
        List<Equipment> equipmentList = companyService.findEquipmentByCompanyIdAndName(companyId, name);
        return new ResponseEntity<>(equipmentList, HttpStatus.OK);
    }


}
