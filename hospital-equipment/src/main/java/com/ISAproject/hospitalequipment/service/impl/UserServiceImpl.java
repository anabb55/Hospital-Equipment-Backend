package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.repository.UserRepo;
import com.ISAproject.hospitalequipment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    public User create(User user){
       return userRepo.save(user);
    }

    public List<User> findAll() {
        return  userRepo.findAll();
    }
}
