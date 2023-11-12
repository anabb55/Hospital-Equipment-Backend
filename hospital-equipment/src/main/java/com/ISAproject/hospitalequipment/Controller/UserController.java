package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addCompanyProfile(@RequestBody User user){
        userRepo.save(user);
    }

}
