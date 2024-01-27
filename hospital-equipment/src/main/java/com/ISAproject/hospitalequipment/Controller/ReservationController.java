package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.domain.enums.ReservationStatus;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import com.ISAproject.hospitalequipment.dto.ReservationDTO;
import com.ISAproject.hospitalequipment.service.AppointmentService;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import com.ISAproject.hospitalequipment.service.ReservationService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private RegisteredUserService registeredUserService;


    @CrossOrigin(origins = "*")
    @PostMapping("/createReservation/{registerUserId}")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO,@PathVariable Long registerUserId) {
        Reservation reservation = new Reservation();
        RegisteredUser user=registeredUserService.findOne(Math.toIntExact(registerUserId));
        reservation.setPenaltyPoints(0L);
        reservation.setRegisteredUser(user);
        reservation.setReservationStatus(ReservationStatus.RESERVED);
        reservation = reservationService.save(reservation);
        return new ResponseEntity<>(new ReservationDTO(reservation), HttpStatus.CREATED);
    }


    @PostMapping("/createReservationPredefined/{UserId}")
    public ResponseEntity<ReservationDTO> createReservationPredefined(@RequestBody Appointment appointment,@PathVariable Long UserId) {
        Reservation reservation = new Reservation();
        RegisteredUser user=registeredUserService.findOne(Math.toIntExact(UserId));
        reservation.setPenaltyPoints(0L);
        reservation.setRegisteredUser(user);
        reservation.setReservationStatus(ReservationStatus.RESERVED);
        reservation.setAppointment(appointment);
        reservation = reservationService.create(reservation);
        return new ResponseEntity<>(new ReservationDTO(reservation), HttpStatus.CREATED);
    }

    @GetMapping("/sendEmailWithQRCode")
    public void sendQRCode() throws IOException, WriterException {
        reservationService.getDataForQRCode();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteByAppointmentId/{appointmentId}")
    public void DeleteByAppointmentId(@PathVariable Long appointmentId){
        reservationService.deleteByAppointmentId(appointmentId);
    }

}
