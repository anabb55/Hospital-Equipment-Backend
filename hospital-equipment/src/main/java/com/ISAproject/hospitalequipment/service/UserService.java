package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


public interface UserService {

   User createUser(User user, UserDTO userDTO);

   List<User> findAll();

   public User findByEmail(String email);

   public User save(User user);
   @Cacheable("user")
   public User getById(Long id);

   @CacheEvict(cacheNames = {"user"}, allEntries = true)
   void removeFromCache();
}
