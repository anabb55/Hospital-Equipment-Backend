package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.SystemAdmin;
import com.ISAproject.hospitalequipment.service.CompanyService;
import com.ISAproject.hospitalequipment.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public SystemAdmin save(@RequestBody SystemAdmin admin) {
        return systemAdminService.save(admin);
    }
}
