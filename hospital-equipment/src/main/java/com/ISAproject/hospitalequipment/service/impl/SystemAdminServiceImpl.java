package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.SystemAdmin;
import com.ISAproject.hospitalequipment.repository.RegisteredUserRepo;
import com.ISAproject.hospitalequipment.repository.SystemAdminRepo;
import com.ISAproject.hospitalequipment.service.SystemAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemAdminServiceImpl implements SystemAdminService {

    @Autowired
    private SystemAdminRepo systemAdminRepo;
    public SystemAdmin findOne(Integer id) {
        return systemAdminRepo.findById(Long.valueOf(id)).orElseGet(null);
    }

    public SystemAdmin save(SystemAdmin admin) {
        return systemAdminRepo.save(admin);
    }

    public void remove(Integer id) {
        systemAdminRepo.deleteById(Long.valueOf(id));
    }

}
