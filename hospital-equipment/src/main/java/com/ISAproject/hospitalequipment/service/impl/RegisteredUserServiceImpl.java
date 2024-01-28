package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.*;
import com.ISAproject.hospitalequipment.domain.enums.UserCategory;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.repository.LoyaltyProgramRepo;
import com.ISAproject.hospitalequipment.repository.RegisteredUserRepo;
import com.ISAproject.hospitalequipment.service.*;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service

public class RegisteredUserServiceImpl implements RegisteredUserService {
    @Autowired
    private RegisteredUserRepo registeredUserRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private LoyaltyProgramRepo loyaltyProgramRepo;

    public List<RegisteredUser> findAll() {
        return registeredUserRepo.findAll();
    }

    public RegisteredUser findOne(Integer id) {
        return registeredUserRepo.findById(Long.valueOf(id)).orElseGet(null);
    }

    public RegisteredUser createRegisteredUser(UserDTO userDTO) throws MessagingException {
       RegisteredUser registeredUser = new RegisteredUser(); //tranzijentno

        registeredUser = (RegisteredUser) userService.createUser(registeredUser,userDTO);

        List<Role> roles = roleService.findByName("ROLE_REGISTERED_USER");
        registeredUser.setRoles(roles);
        registeredUser.setUserCategory(UserCategory.REGULAR);
        registeredUser.setPenaltyPoints(0);
        registeredUser.setEnabled(false);


        registeredUserRepo.save(registeredUser);
        emailService.sendEmail(registeredUser);
        return registeredUser;
    }

    public void remove(Integer id) {
        registeredUserRepo.deleteById(Long.valueOf(id));

    }

    public RegisteredUser save(RegisteredUser registeredUser) {
        return registeredUserRepo.save(registeredUser);
    }

    @Override
    public RegisteredUser updatePenaltyPoints(Long userId, RegisteredUser registeredUser, Appointment appointment) {
        Optional<RegisteredUser> OptionalRegUser = registeredUserRepo.findById(userId);

        RegisteredUser regUser = OptionalRegUser.get();


        LocalDateTime now = LocalDateTime.now();
        LocalDateTime appointmentDateTime = LocalDateTime.of(appointment.getDate(), appointment.getStartTime() );

        long minutesDifference = ChronoUnit.MINUTES.between(now,appointmentDateTime);

        if(minutesDifference<1440){
            regUser.setPenaltyPoints(registeredUser.getPenaltyPoints() + 2);
             return registeredUserRepo.save(regUser);
        }
        else {
            regUser.setPenaltyPoints(registeredUser.getPenaltyPoints() + 1);
           return  registeredUserRepo.save(regUser);
        }
    }

    @Override
    public RegisteredUser updateLoyaltyProgram(Long id, int winPoints, int penaltyPoints) {
        RegisteredUser old = registeredUserRepo.findById(id).get();

        if (old !=null ) {

            old.setPenaltyPoints(old.getPenaltyPoints()+penaltyPoints);
            old.setAccumulatedPoints(old.getAccumulatedPoints()+winPoints);

            if(old.getAccumulatedPoints() - old.getPenaltyPoints() >5 && old.getAccumulatedPoints() - old.getPenaltyPoints()<10){
                old.setLoyaltyProgram(loyaltyProgramRepo.findById(2L).get());
                old.setUserCategory(UserCategory.SILVER);
            }
            if(old.getAccumulatedPoints() - old.getPenaltyPoints() >10){
                old.setLoyaltyProgram(loyaltyProgramRepo.findById(3L).get());
                old.setUserCategory(UserCategory.GOLD);
            }

            registeredUserRepo.save(old);
            return old;
        }
        return null;
    }

    @Override
    public Optional<RegisteredUser> findById(Long id) {
        return registeredUserRepo.findById(id);
    }

    public boolean existsById(Integer id)
    {
        if(id!=null)

               return  registeredUserRepo.existsById(Long.valueOf(id));


        return false;
    }

    public boolean verify(String email){
        RegisteredUser registeredUser = registeredUserRepo.findByEmail(email);

        if(registeredUser==null || registeredUser.isEnabled()){
            return  false;
        }
        else{
            registeredUser.setEnabled(true);
            registeredUserRepo.save(registeredUser);
            return true;
        }
    }



}
