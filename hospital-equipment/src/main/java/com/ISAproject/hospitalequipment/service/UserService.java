package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import org.springframework.stereotype.Service;
import java.util.List;


public interface UserService {

   User createUser(User user, UserDTO userDTO);

   List<User> findAll();

   public User findByEmail(String email);

   public User save(User user);
   public User getById(Long id);

}
