package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import com.ISAproject.hospitalequipment.dto.RegisterUserDTO;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.mapper.registredUserDTOMapper;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/registeredUsers")
public class RegisteredUserController {
    @Autowired
    private RegisteredUserService registeredUserService;

    @Autowired
    private registredUserDTOMapper userDTOMapper;






    @CrossOrigin(origins = "*")
    @GetMapping("/getById/{id}")
    public ResponseEntity<RegisterUserDTO> getUser(@PathVariable Integer id) {
        RegisteredUser registeredUser = registeredUserService.findOne(id);

        if (registeredUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new RegisterUserDTO(registeredUser), HttpStatus.OK);
    }




    @PostMapping(value="/signUp")
    public ResponseEntity<User> createRegisteredUser(@RequestBody UserDTO userDTO) throws MessagingException {

       RegisteredUser registeredUser= registeredUserService.createRegisteredUser(userDTO);

        if(registeredUser == null){
            return new  ResponseEntity<>(registeredUser, HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }



    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@RequestBody RegisterUserDTO registerUserDTO, @PathVariable Integer id) {
        RegisteredUser registeredUser = registeredUserService.findOne(id);

        if (registeredUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        registeredUser.setFirstName(registerUserDTO.getFirstname());
        registeredUser.setLastName(registerUserDTO.getLastname());
        registeredUser.setPenaltyPoints(registerUserDTO.getPenaltyPoints());
        registeredUser.setUserCategory(registerUserDTO.getUserCategory());
        registeredUser.setPassword(registerUserDTO.getPassword());
        registeredUser.setEmail(registerUserDTO.getEmail());
        registeredUser.setOccupation(registerUserDTO.getOccupation());
        registeredUser.setAddress(registerUserDTO.getAddress());
        registeredUser.setPhoneNumber(registerUserDTO.getPhoneNumber());
        RegisteredUser updatedRegUser = registeredUserService.save(registeredUser);

        if (updatedRegUser != null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
