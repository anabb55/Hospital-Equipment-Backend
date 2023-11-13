package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.User;
import org.springframework.stereotype.Service;
import java.util.List;


public interface UserService {

   User create(User user);

   List<User> findAll();
}
