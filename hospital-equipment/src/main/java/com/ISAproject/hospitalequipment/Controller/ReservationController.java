package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.domain.enums.ReservationStatus;
import com.ISAproject.hospitalequipment.dto.ReservationDTO;
import com.ISAproject.hospitalequipment.service.EmailService;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import com.ISAproject.hospitalequipment.service.ReservationService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private RegisteredUserService registeredUserService;

    @Autowired
    private EmailService emailService;

    @CrossOrigin(origins = "*")
    @PostMapping("/createReservation/{registerUserId}")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO,@PathVariable Long registerUserId) {
        Reservation reservation = new Reservation();
        RegisteredUser user=registeredUserService.getById(Math.toIntExact(registerUserId));
        reservation.setPenaltyPoints(0L);
        reservation.setRegisteredUser(user);
        reservation.setReservationStatus(ReservationStatus.RESERVED);
        reservation = reservationService.save(reservation);
        return new ResponseEntity<>(new ReservationDTO(reservation), HttpStatus.CREATED);
    }


    @PostMapping("/createReservationPredefined/{UserId}")
    public ResponseEntity<ReservationDTO> createReservationPredefined(@RequestBody Appointment appointment,@PathVariable Long UserId) {
        Reservation reservation = new Reservation();
        RegisteredUser user=registeredUserService.getById(Math.toIntExact(UserId));
        reservation.setPenaltyPoints(0L);
        reservation.setRegisteredUser(user);
        reservation.setReservationStatus(ReservationStatus.RESERVED);
        reservation.setAppointment(appointment);
        reservation = reservationService.create(reservation);
        return new ResponseEntity<>(new ReservationDTO(reservation), HttpStatus.CREATED);
    }
    @GetMapping("/qrCode/{userId}")
    public List<Map<String, Object>> getReservationsQRForUser(@PathVariable Long userId,
                                                              @RequestParam(required = false) String status)
            throws IOException, WriterException {
        return reservationService.getDataForUserQRCode(userId, status);
    }
    @GetMapping("/sendEmailWithQRCode")
    public void sendQRCode() throws IOException, WriterException {
        reservationService.getDataForQRCode();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/isReservationTaken/{idAppointment}")
    public Boolean isReservationTaken(@PathVariable int idAppointment) {
        return reservationService.isReservationTaken(idAppointment);
    }


    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteByAppointmentId/{appointmentId}")
    public void DeleteByAppointmentId(@PathVariable Long appointmentId) {
        reservationService.deleteByAppointmentId(appointmentId);

    }
      @CrossOrigin(origins = "*")
    @PutMapping("/updateStatus/{resId}")
    public ResponseEntity<ReservationDTO> updateStatus(@PathVariable("resId") Long reservationId  ){
        Reservation reservation= reservationService.getById(reservationId);
       reservation.setReservationStatus(ReservationStatus.TAKEN);


        reservationService.saveReservation(reservation);
        emailService.sendReservationEmail(reservation.getRegisteredUser());
        return new ResponseEntity<>(new ReservationDTO(reservation),HttpStatus.OK);
}
    @GetMapping("/getAll")
    public ResponseEntity<List<ReservationDTO>> getAll() {
        List<Reservation> reservations= reservationService.getAll();

        List<ReservationDTO> reservationDTOS = new ArrayList<>();

        for (Reservation r : reservations) {
            reservationDTOS.add(new ReservationDTO(r));
        }

        return new ResponseEntity<>(reservationDTOS, HttpStatus.OK);


    }

}
