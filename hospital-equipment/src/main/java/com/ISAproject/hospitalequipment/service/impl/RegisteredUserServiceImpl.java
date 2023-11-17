package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.repository.RegisteredUserRepo;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RegisteredUserServiceImpl implements RegisteredUserService {
    @Autowired
    private RegisteredUserRepo registeredUserRepo;

    public List<RegisteredUser> findAll() {
        return registeredUserRepo.findAll();
    }

    public RegisteredUser findOne(Integer id) {
        return registeredUserRepo.findById(Long.valueOf(id)).orElseGet(null);
    }

    public RegisteredUser save(RegisteredUser course) {
        return registeredUserRepo.save(course);
    }

    public void remove(Integer id) {
        registeredUserRepo.deleteById(Long.valueOf(id));

    }

    public boolean existsById(Integer id)
    {
        if(id!=null)
            {
               return  registeredUserRepo.existsById(Long.valueOf(id));
            }

        return false;
    }



}
