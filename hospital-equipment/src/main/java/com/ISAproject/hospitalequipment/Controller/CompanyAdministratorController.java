package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.CompanyAdministratorDTO;
import com.ISAproject.hospitalequipment.dto.CompanyDTO;
import com.ISAproject.hospitalequipment.service.CompanyAdministratorService;
import com.ISAproject.hospitalequipment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/companyAdministrators")
public class CompanyAdministratorController {

    @Autowired
    private CompanyAdministratorService companyAdministratorService;

    @Autowired
    private UserService userService;


    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyAdministratorDTO>> getAll(){
        List<CompanyAdministrator> administrators= companyAdministratorService.findAll();

        List<CompanyAdministratorDTO> administratorDTOS= new ArrayList<>();

        for (CompanyAdministrator s : administrators) {
            administratorDTOS.add(new CompanyAdministratorDTO(s));
        }

        return new ResponseEntity<>(administratorDTOS, HttpStatus.OK);
    }

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
       // CompanyAdministrator updatedAdmin = companyAdministratorService.update(admin, id);

       // User user= userService.getById(id);

       // user.setUsername(admin.getUsername());
       // user.setEmail(admin.getEmail());

       // userService.save(user);

        userService.updateUsername(3L,admin.getUsername());

        return new ResponseEntity<>(admin, HttpStatus.OK);

    }
    @GetMapping("/getAdminById/{id}")
    public ResponseEntity<CompanyAdministrator> getCompanyAdmin(@PathVariable Long id) {

        CompanyAdministrator companyA = companyAdministratorService.getById(id);


        return new ResponseEntity<>(companyA, HttpStatus.OK);
    }

}
