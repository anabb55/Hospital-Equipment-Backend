package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companyProfile")
public class CompanyController {
    @Autowired

    private CompanyService companyService;

    @GetMapping("/")
    public List<Company> getAllCompanyProfiles(){
        return companyService.getAll();
    }


    @PostMapping("/save")
    public ResponseEntity<Company> saveCompanyProfile(@RequestBody Company company) {
        Company createdCompany = companyService.save(company);
        return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
    }


    @GetMapping("/byAdmin/{id}")
    public ResponseEntity<List<Company>> getByAdministrator(@PathVariable int id){
        List<Company> companies= companyService.getByAdministrator(id);
        return new ResponseEntity<>(companies,HttpStatus.OK);
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
        return companyService.findCompaniesByEquipment(e);

    }
    */


    @GetMapping("/getById/{id}")
    public Company getById(@PathVariable Long id){
        return companyService.getById(id);
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

    @CrossOrigin(origins = "*")
    @PutMapping("/addEquipmentStock/{id}")
    public ResponseEntity<Company> addEquipmentStock(@PathVariable Long companyId, @RequestBody EquipmentStock equipmentStock) {
        Company newCompany=companyService.addEquipmentStock(equipmentStock,companyId);
        return new ResponseEntity<>(newCompany, HttpStatus.OK);

    }
}
