package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Role;
import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.repository.UserRepo;
import com.ISAproject.hospitalequipment.service.RoleService;
import com.ISAproject.hospitalequipment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    public User createUser(User user,UserDTO userDTO){


        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstname());
        user.setLastName(userDTO.getLastname());
        user.setAddress(userDTO.getAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setOccupation(userDTO.getOccupation());

        return userRepo.save(user);

    }

    public List<User> findAll() {
        return  userRepo.findAll();
    }

   public User findByEmailIgnoreCase(String email) {return userRepo.findByEmailIgnoreCase(email);}
}
