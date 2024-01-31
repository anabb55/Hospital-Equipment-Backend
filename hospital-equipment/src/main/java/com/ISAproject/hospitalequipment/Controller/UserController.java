package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")

    public List<User> getAllUsers() {
        return userService.findAll();

    }


    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Long> update(@PathVariable("id") Long id, @RequestBody String password ) {
        // CompanyAdministrator updatedAdmin = companyAdministratorService.update(admin, id);

        User user= userService.getById(id);


        // user.setEmail(admin.getEmail());
        user.setPassword(passwordEncoder.encode(password));
        user.setWaslogged(true);


        userService.save(user);

        //  userService.updateUsername(3L,admin.getUsername());

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

    @CrossOrigin(origins = "*")

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") Long id){

        User user= userService.getById(id);
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<UserDTO> getByEmail(@PathVariable("email") String email){

        User user= userService.findByEmail(email);
        return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/WasLogged/{id}")
    public ResponseEntity<Boolean> WasLogged(@PathVariable("id") Long id){

        User user= userService.getById(id);
        return new ResponseEntity<>(user.isWaslogged(), HttpStatus.OK);
    }



}
