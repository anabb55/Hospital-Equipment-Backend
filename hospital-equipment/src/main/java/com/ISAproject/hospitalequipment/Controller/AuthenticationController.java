package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.service.EmailService;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import com.ISAproject.hospitalequipment.service.UserService;
import jakarta.mail.MessagingException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegisteredUserService registeredUserService;


    @RequestMapping(value="/signUp", method = RequestMethod.POST)
    public ResponseEntity<User> signUp(@RequestBody UserDTO userDTO) throws MessagingException, UnsupportedEncodingException {
        RegisteredUser registeredUser= registeredUserService.createRegisteredUser(userDTO);

      if(registeredUser == null){
          return new  ResponseEntity<>(registeredUser, HttpStatus.BAD_REQUEST);
       }
        return  new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

}
