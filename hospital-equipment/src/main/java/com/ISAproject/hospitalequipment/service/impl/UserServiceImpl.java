package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.repository.UserRepo;
import com.ISAproject.hospitalequipment.service.RoleService;
import com.ISAproject.hospitalequipment.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    private final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Transactional
    public User createUser(User user,UserDTO userDTO){

        user.setUsername(userDTO.getUsername());

        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());


        Address address = new Address();
        address.setId(userDTO.getAddress().getId());
        address.setCity(userDTO.getAddress().getCity());
        address.setCountry(userDTO.getAddress().getCountry());
        address.setStreet(userDTO.getAddress().getStreet());
        address.setNumber(userDTO.getAddress().getNumber());

        user.setAddress(address);
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setOccupation(userDTO.getOccupation());

        return userRepo.save(user);

    }

    public List<User> findAll() {
        return  userRepo.findAll();
    }

    public User findByEmail(String email) {
            return    userRepo.findByEmail(email);
      }

    public User save(User user){
        return userRepo.save(user);
    }

    public User getById(Long id){

        return userRepo.getById(id);
    }

    public void removeFromCache() {
        LOG.info("Users removed from cache!");

    }

}
