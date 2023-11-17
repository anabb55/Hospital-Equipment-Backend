package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;


public interface UserService {

   User create(UserDTO userDTO);

   List<User> findAll();
}