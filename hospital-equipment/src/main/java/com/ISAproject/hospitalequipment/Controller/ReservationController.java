package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.domain.WaitGroup;
import com.ISAproject.hospitalequipment.domain.enums.ReservationStatus;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import com.ISAproject.hospitalequipment.dto.ReservationDTO;
import com.ISAproject.hospitalequipment.service.EmailService;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import com.ISAproject.hospitalequipment.service.ReservationService;
import com.google.zxing.WriterException;
import jakarta.persistence.OptimisticLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
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

    private WaitGroup waitGroup = new WaitGroup(2);




    @CrossOrigin
    @PutMapping(value = "/update/{id}/{userId}")
    public ResponseEntity<AppointmentDTO> update(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO, @PathVariable Long userId) {
//        waitGroup.done();
//        try {
//            waitGroup.await();
//        } catch (InterruptedException e) {
//            System.out.println("Error happening");
//        }

        try {
            Appointment app = reservationService.updateStatus(id,appointmentDTO, userId);
            reservationService.createAppointmentReservation(id, appointmentDTO, userId);
            return new ResponseEntity<>(new AppointmentDTO(app), HttpStatus.OK);
        } catch (ObjectOptimisticLockingFailureException ex) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @CrossOrigin(origins = "*")
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

    @CrossOrigin(origins = "*")
    @PutMapping("/updateStatusToExpired/{resId}")
    public ResponseEntity<ReservationDTO> updateStatusToExpired(@PathVariable("resId") Long reservationId  ){
        Reservation reservation= reservationService.getById(reservationId);
        reservation.setReservationStatus(ReservationStatus.EXPIRED);
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

    @CrossOrigin(origins = "*")
    @PutMapping("/checkExpiredReservations/")
    public ResponseEntity<Void> checkExpiredReservations(  ){

        reservationService.checkExpiredReservations();

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
