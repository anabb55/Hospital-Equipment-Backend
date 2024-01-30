package com.ISAproject.hospitalequipment.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ISAproject.hospitalequipment.domain.*;
import com.ISAproject.hospitalequipment.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ISAproject.hospitalequipment.domain.enums.AppointmentStatus;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private CompanyAdministratorService companyAdminService;
    @Autowired
    private CompanyService companyService;


    @CrossOrigin(origins = "*")


    @GetMapping("/getAppointmentsForCompany/{id}")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentsByCompany(@PathVariable Long id){
        List<Appointment> appointments = appointmentService.getFreeAppointmentsByCompany(id);

        List<AppointmentDTO> appointmentDTOS = appointments.stream().map(AppointmentDTO::new).collect(Collectors.toList());

        return new ResponseEntity<>(appointmentDTOS, HttpStatus.OK);
    }

    @GetMapping("/generateRandomAppointments/{companyId}")
    public ResponseEntity<List<AppointmentDTO>> generateRandomAppointments(
            @PathVariable Long companyId,
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date
    ) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();

        List<Appointment> generatedAppointments = appointmentService.generateRandomAppointments(companyId, localDate);

        List<AppointmentDTO> appointmentDTOs = generatedAppointments.stream()
                .map(AppointmentDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(appointmentDTOs, HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/getTakenAppointmentsForCompany/{id}")
    public ResponseEntity<List<AppointmentDTO>> getTakenAppointmentsByCompany(@PathVariable Long id){
        List<Appointment> appointments = appointmentService.findTakenAppointmentsByCompany(id);

        List<AppointmentDTO> appointmentDTOS = appointments.stream().map(AppointmentDTO::new).collect(Collectors.toList());

        return new ResponseEntity<>(appointmentDTOS, HttpStatus.OK);
    }

    @GetMapping("/futureAppointment/{userId}")
    public ResponseEntity<List<AppointmentDTO>> getFutureAppointments(  @PathVariable Long userId){
        List<Appointment> futureAppointments = appointmentService.findFutureAppointmentsByUserId(userId);
        List<AppointmentDTO> appointmentDTOs = futureAppointments.stream()
                .map(AppointmentDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(appointmentDTOs, HttpStatus.OK);

    }



    @CrossOrigin(origins = "*")

    @PostMapping(value="/create/{companyId}")
    public ResponseEntity<AppointmentDTO> saveAppointment(@PathVariable Long companyId, @RequestBody AppointmentDTO appointmentDTO) {
//        Appointment appointment = new Appointment();
//        appointment.setId(appointmentDTO.getId());
//        appointment.setDate(appointmentDTO.getDate());
//        appointment.setAppointmentStatus(AppointmentStatus.TAKEN);
//        appointment.setEndTime(appointmentDTO.getEndTime());
//
//        Company company = companyService.getById(companyId);
//
//
//        if (company == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//
//        List<CompanyAdministrator> administrators = appointmentService.findAvailableAdministrator(appointmentDTO.getStartTime(),appointmentDTO.getEndTime(), appointmentDTO.getDate(),companyId);
//
//        if (administrators == null || administrators.isEmpty()) {
//            throw new IllegalStateException("No available administrators found.");
//        }
//
//        for (CompanyAdministrator administrator : administrators) {
//            if (administrator.getCompany().getId().equals(companyId)){
//                appointment.setAdministrator(administrator);
//                break;
//            }
//        }
//
//
//
//
//        appointment.setStartTime(appointmentDTO.getStartTime());
//
//        appointmentService.save(appointment);

        return new ResponseEntity<>(new AppointmentDTO(appointmentService.saveAppointment(companyId, appointmentDTO)), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping(value = "/update/{id}/{userId}")

    public ResponseEntity<AppointmentDTO> cancelAppointment(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO, @PathVariable Long userId) {



        return new ResponseEntity<>(new AppointmentDTO(appointmentService.cancelAppointment(id,appointmentDTO,userId)), HttpStatus.OK);


    }



    @CrossOrigin
    @PutMapping(value = "/update/{id}")

    public ResponseEntity<AppointmentDTO> update(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {



        return new ResponseEntity<>(new AppointmentDTO(appointmentService.updateStatus(id,appointmentDTO)), HttpStatus.OK);


    }

    @CrossOrigin(origins = "*")
    @PostMapping(value="/createApp/{date}/{startTime}/{endTime}/{adminId}")
    public ResponseEntity<Void> createApp( @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                           @PathVariable("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
                                           @PathVariable("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime, @PathVariable("adminId") Long adminId){


        Appointment newApp= new Appointment();
        newApp.setDate(date);
        newApp.setEndTime(endTime);
        newApp.setStartTime(startTime);
        newApp.setAppointmentStatus(AppointmentStatus.PREDEFINED);
        newApp.setAdministrator(this.companyAdminService.getById(adminId));
        this.appointmentService.save(newApp);


        return new ResponseEntity<>(HttpStatus.OK);
    }


}

