package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.RegisterUserDTO;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.mapper.registredUserDTOMapper;
import com.ISAproject.hospitalequipment.repository.RegisteredUserRepo;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import com.ISAproject.hospitalequipment.service.UserService;
import io.swagger.v3.oas.annotations.media.Content;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/registeredUsers")
public class RegisteredUserController {
    @Autowired
    private RegisteredUserService registeredUserService;

    @Autowired
    private registredUserDTOMapper userDTOMapper;



    @GetMapping(value = "/all")
    public ResponseEntity<List<RegisterUserDTO>> getAllRegisteredUsers() {

        List<RegisteredUser> registerUsers = registeredUserService.findAll();

        List<RegisterUserDTO> teachersDTO = new ArrayList<>();
        for (RegisteredUser s : registerUsers) {
            teachersDTO.add(new RegisterUserDTO());
        }

        return new ResponseEntity<>(teachersDTO, HttpStatus.OK);
    }

    @PostMapping(value="/signUp")
    public ResponseEntity<User> createRegisteredUser(@RequestBody UserDTO userDTO){

       RegisteredUser registeredUser= registeredUserService.createRegisteredUser(userDTO);

        if(registeredUser == null){
            return new  ResponseEntity<>(registeredUser, HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

//    izmestiti impl u servis
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> update(@RequestBody RegisterUserDTO registerUserDTO, @PathVariable Integer id) {
//        RegisteredUser registeredUser = userService.findOne(id);
//
//        if (registeredUser == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        registeredUser.setFirstName(registerUserDTO.getFirstname());
//        registeredUser.setLastName(registerUserDTO.getLastname());
//        registeredUser.setPenaltyPoints(registerUserDTO.getPenaltyPoints());
//        registeredUser.setUserCategory(registerUserDTO.getUserCategory());
//        registeredUser.setPassword(registerUserDTO.getPassword());
//        registeredUser.setEmail(registerUserDTO.getEmail());
//        registeredUser.setOccupation(registerUserDTO.getOccupation());
//        registeredUser.setAddress(registerUserDTO.getAddress());
//        registeredUser.setPhoneNumber(registerUserDTO.getPhoneNumber());
//        RegisteredUser updatedRegUser = userService.save(registeredUser);
//
//        if (updatedRegUser != null) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }






}
