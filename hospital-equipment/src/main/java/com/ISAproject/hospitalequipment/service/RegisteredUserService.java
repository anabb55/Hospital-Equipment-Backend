package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface RegisteredUserService {
    public List<RegisteredUser> findAll() ;
    public RegisteredUser findOne(Integer id) ;
    public RegisteredUser createRegisteredUser(UserDTO userDTO) throws MessagingException;
    public void remove(Integer id);
    public boolean existsById(Integer id);


    public boolean verify(String email);

    public RegisteredUser save(RegisteredUser registeredUser) ;


}
