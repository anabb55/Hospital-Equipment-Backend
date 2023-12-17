package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import com.ISAproject.hospitalequipment.dto.CompanyAdministratorDTO;
import com.ISAproject.hospitalequipment.dto.CompanyDTO;
import com.ISAproject.hospitalequipment.service.CompanyAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/companyAdministrators")
public class CompanyAdministratorController {

    @Autowired
    private CompanyAdministratorService companyAdministratorService;


    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyAdministratorDTO>> getAll(){
        List<CompanyAdministrator> administrators= companyAdministratorService.findAll();

        List<CompanyAdministratorDTO> companyAdministratorDTOs = new ArrayList<>();

        for (CompanyAdministrator s : administrators) {
            companyAdministratorDTOs.add(new CompanyAdministratorDTO(s));
        }

        return new ResponseEntity<>(companyAdministratorDTOs, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<CompanyAdministratorDTO> createAdministrator(@RequestBody CompanyAdministratorDTO administrator) {

        CompanyAdministrator admin  = new CompanyAdministrator();
        admin.setId(administrator.getId());


        admin.setEmail(administrator.getEmail());
        admin.setPassword(administrator.getPassword());
        admin.setOccupation(administrator.getOccupation());
        admin.setFirstName(administrator.getFirstname());
        admin.setLastName(administrator.getLastname());
        admin.setPhoneNumber(administrator.getPhoneNumber());
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
    public ResponseEntity<CompanyAdministratorDTO> update(@PathVariable Long id, @RequestBody CompanyAdministratorDTO administrator) {

        CompanyAdministrator admin  = new CompanyAdministrator();
        admin.setId(id);
        admin.setEmail(administrator.getEmail());

        admin.setPassword(administrator.getPassword());
        admin.setOccupation(administrator.getOccupation());
        admin.setFirstName(administrator.getFirstname());
        admin.setLastName(administrator.getLastname());
        admin.setPhoneNumber(administrator.getPhoneNumber());
            Address address = new Address();
            address.setId(administrator.getAddress().getId());
            address.setCity(administrator.getAddress().getCity());
            address.setCountry(administrator.getAddress().getCountry());
            address.setStreet(administrator.getAddress().getStreet());
            address.setNumber(administrator.getAddress().getNumber());
            admin.setAddress(address);
        CompanyAdministrator updatedAdmin = companyAdministratorService.update(admin, id);
        if (updatedAdmin == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new CompanyAdministratorDTO(updatedAdmin), HttpStatus.OK);

    }

}
