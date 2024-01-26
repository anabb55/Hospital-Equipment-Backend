package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Address;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.SystemAdmin;
import com.ISAproject.hospitalequipment.dto.CompanyAdministratorDTO;
import com.ISAproject.hospitalequipment.dto.SystemAdminDto;
import com.ISAproject.hospitalequipment.service.CompanyService;
import com.ISAproject.hospitalequipment.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/systemAdmins")
public class SystemAdminController {

    @Autowired
    private SystemAdminService systemAdminService;


    @PostMapping("/save")
    public ResponseEntity<SystemAdminDto> save(@RequestBody SystemAdminDto administrator) {
        SystemAdmin admin  = new SystemAdmin();
        admin.setId(administrator.getId());
        admin.setEmail(administrator.getEmail());
        admin.setPassword(administrator.getPassword());
        admin.setOccupation(administrator.getOccupation());
        admin.setFirstname(administrator.getFirstname());
        admin.setLastname(administrator.getLastname());
        admin.setPhoneNumber(admin.getPhoneNumber());
        admin.setUsername(admin.getUsername());
        Address address = new Address();
        address.setId(administrator.getAddress().getId());
        address.setCity(administrator.getAddress().getCity());
        address.setCountry(administrator.getAddress().getCountry());
        address.setStreet(administrator.getAddress().getStreet());
        address.setNumber(administrator.getAddress().getNumber());
        admin.setAddress(address);
        admin.setRoles(administrator.getRoles());
        admin.setUserCategory(administrator.getUserCategory());
        SystemAdmin createdAdministrator = systemAdminService.save(admin);
        if (createdAdministrator == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new SystemAdminDto(createdAdministrator), HttpStatus.OK);

    }
}
