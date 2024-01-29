package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.*;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import com.ISAproject.hospitalequipment.dto.RegisterUserDTO;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.mapper.registredUserDTOMapper;
import com.ISAproject.hospitalequipment.repository.LoyaltyProgramRepo;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/registeredUsers")
public class RegisteredUserController {
    @Autowired
    private RegisteredUserService registeredUserService;

    @Autowired
    private registredUserDTOMapper userDTOMapper;

    @Autowired
    private LoyaltyProgramRepo loyaltyProgramRepo;






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

        registeredUser.setFirstname(registerUserDTO.getFirstname());
        registeredUser.setLastname(registerUserDTO.getLastname());
        registeredUser.setPenaltyPoints(registerUserDTO.getPenaltyPoints());
        registeredUser.setUserCategory(registerUserDTO.getUserCategory());
        registeredUser.setPassword(registerUserDTO.getPassword());
        registeredUser.setEmail(registerUserDTO.getEmail());
        registeredUser.setOccupation(registerUserDTO.getOccupation());

        Address address = new Address();
        address.setId(registerUserDTO.getAddress().getId());
        address.setCity(registerUserDTO.getAddress().getCity());
        address.setCountry(registerUserDTO.getAddress().getCountry());
        address.setStreet(registerUserDTO.getAddress().getStreet());
        address.setNumber(registerUserDTO.getAddress().getNumber());

        registeredUser.setAddress(address);
        registeredUser.setPhoneNumber(registerUserDTO.getPhoneNumber());
        RegisteredUser updatedRegUser = registeredUserService.save(registeredUser);

        if (updatedRegUser != null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @CrossOrigin
    @PutMapping("/updatePenaltyPoints/{UserId}")
    public ResponseEntity<RegisterUserDTO> updatePenaltyPoints( @PathVariable Long UserId, @RequestBody AppointmentDTO appointmentDTO){
        Optional<RegisteredUser> OptionalRegUser = registeredUserService.findById(UserId);

        RegisteredUser regUser = OptionalRegUser.get();


        LocalDateTime now = LocalDateTime.now();
        LocalDateTime appointmentDateTime = LocalDateTime.of(appointmentDTO.getDate(), appointmentDTO.getStartTime() );

        long minutesDifference = ChronoUnit.MINUTES.between(now,appointmentDateTime);

        if(minutesDifference<1440){
            regUser.setPenaltyPoints(regUser.getPenaltyPoints() + 2);
            regUser = registeredUserService.save(regUser);
            return  new ResponseEntity<>(new RegisterUserDTO((regUser)), HttpStatus.OK);
        }
        else {
            regUser.setPenaltyPoints(regUser.getPenaltyPoints() + 1);
            regUser = registeredUserService.save(regUser);
            return  new ResponseEntity<>(new RegisterUserDTO((regUser)), HttpStatus.OK);
        }
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/updateLoyaltyProgram/{id}/{winPoints}/{penaltyPoints}")
    public ResponseEntity<RegisterUserDTO> updateLoyaltyProgram(@PathVariable Long id, @PathVariable int winPoints, @PathVariable int penaltyPoints){

        RegisteredUser regUser = registeredUserService.updateLoyaltyProgram(id,winPoints,penaltyPoints);
        return  new ResponseEntity<>(new RegisterUserDTO(regUser), HttpStatus.OK);
    }






}
