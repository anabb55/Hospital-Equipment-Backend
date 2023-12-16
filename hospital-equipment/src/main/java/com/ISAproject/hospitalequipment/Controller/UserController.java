package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.repository.UserRepo;
import com.ISAproject.hospitalequipment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

        //@PreAuthorize("hasRole('REGISTERED_USER')")
    @GetMapping("/")

    public List<User> getAllUsers() {
        return userService.findAll();

    }



//    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
//
//    public void create(@RequestBody UserDTO userDTO){
//        userService.createUser(userDTO);
//    }



}
