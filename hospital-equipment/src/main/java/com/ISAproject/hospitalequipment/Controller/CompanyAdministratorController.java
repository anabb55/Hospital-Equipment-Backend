package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.dto.CompanyAdministratorDTO;
import com.ISAproject.hospitalequipment.dto.CompanyDTO;
import com.ISAproject.hospitalequipment.service.CompanyAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companyAdministrators")
public class CompanyAdministratorController {

    @Autowired
    private CompanyAdministratorService companyAdministratorService;

    /*
    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyAdministrator>> getAll(){
        List<CompanyAdministrator> administrators= companyAdministratorService.findAll();

        return new ResponseEntity<>(administrators, HttpStatus.OK);
    }
*/
    @PostMapping("/save")
    public ResponseEntity<CompanyAdministrator> createAdministrator(@RequestBody CompanyAdministrator administrator) {
        CompanyAdministrator createdAdministrator = companyAdministratorService.save(administrator);
        return new ResponseEntity<>(createdAdministrator, HttpStatus.CREATED);
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
    public ResponseEntity<CompanyAdministrator> update(@PathVariable Long id, @RequestBody CompanyAdministrator admin) {
        CompanyAdministrator updatedAdmin = companyAdministratorService.update(admin, id);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);

    }

}
