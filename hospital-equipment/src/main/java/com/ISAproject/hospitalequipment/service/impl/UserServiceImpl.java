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

    public User create(UserDTO userDTO){
       User user = new User(); //tranzijentno stanje

        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstname());
        user.setLastName(userDTO.getLastname());
        user.setAddress(userDTO.getAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setOccupation(userDTO.getOccupation());
        List<Role> roles = roleService.findByName("ROLE_USER");
        user.setRoles(roles);
        user.setEnabled(true);

        return this.userRepo.save(user);



    }

    public List<User> findAll() {
        return  userRepo.findAll();
    }
}
