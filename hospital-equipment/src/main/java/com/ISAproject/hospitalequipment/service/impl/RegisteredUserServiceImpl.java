package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Role;
import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.repository.RegisteredUserRepo;
import com.ISAproject.hospitalequipment.service.EmailService;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import com.ISAproject.hospitalequipment.service.RoleService;
import com.ISAproject.hospitalequipment.service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service

public class RegisteredUserServiceImpl implements RegisteredUserService {
    @Autowired
    private RegisteredUserRepo registeredUserRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmailService emailService;

    public List<RegisteredUser> findAll() {
        return registeredUserRepo.findAll();
    }

    public RegisteredUser findOne(Integer id) {
        return registeredUserRepo.findById(Long.valueOf(id)).orElseGet(null);
    }

    public RegisteredUser createRegisteredUser(UserDTO userDTO) throws MessagingException {
       RegisteredUser registeredUser = new RegisteredUser(); //tranzijentno

        registeredUser = (RegisteredUser) userService.createUser(registeredUser,userDTO);

        List<Role> roles = roleService.findByName("REGISTERED_USER");
        registeredUser.setRoles(roles);
        registeredUser.setUserCategory(UserCategory.REGULAR);
        registeredUser.setPenaltyPoints(0);
        registeredUser.setEnabled(false);


        registeredUserRepo.save(registeredUser);
        emailService.sendEmail(registeredUser);
        return registeredUser;
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

    public boolean verify(String email){
        RegisteredUser registeredUser = registeredUserRepo.findByEmail(email);

        if(registeredUser==null || registeredUser.isEnabled()){
            return  false;
        }
        else{
            registeredUser.setEnabled(true);
            registeredUserRepo.save(registeredUser);
            return true;
        }
    }



}
