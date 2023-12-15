package com.ISAproject.hospitalequipment.Controller;
import com.ISAproject.hospitalequipment.dto.LoginDTO;
import com.ISAproject.hospitalequipment.dto.UserTokenState;
import com.ISAproject.hospitalequipment.util.TokenUtils;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.service.EmailService;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import com.ISAproject.hospitalequipment.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private RegisteredUserService registeredUserService;


    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(
            @RequestBody LoginDTO authenticationRequest, HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        //ubacuje se korisnik u trenutni security context
        SecurityContextHolder.getContext().setAuthentication(authentication);


        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getUsername(), user.getRoles());
        int expiresIn = tokenUtils.getExpiredIn();


        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
    }

    @RequestMapping(value="/signUp", method = RequestMethod.POST)
    public ResponseEntity<User> signUp(@RequestBody UserDTO userDTO) throws MessagingException {
        if(userService.findByEmail(userDTO.getEmail())!=null){

            return  new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        RegisteredUser registeredUser= registeredUserService.createRegisteredUser(userDTO);

      if(registeredUser == null){
          return new  ResponseEntity<>(registeredUser, HttpStatus.BAD_REQUEST);
       }
        return  new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @RequestMapping(value="/verify", method = RequestMethod.GET)
    public ResponseEntity<Boolean> verifyAccount(@Param("email")String email, HttpServletResponse response) throws IOException {
        if(!registeredUserService.verify(email)){

            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        else{
            response.sendRedirect("http://localhost:4200/successfullyRegistration");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


}
