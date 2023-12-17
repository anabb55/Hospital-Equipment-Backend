package com.ISAproject.hospitalequipment.Controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.domain.enums.AppointmentStatus;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.service.AppointmentService;
import com.ISAproject.hospitalequipment.service.CompanyService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
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
    private CompanyService companyService;

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

    @PostMapping(value="/create/{companyId}")
    public ResponseEntity<AppointmentDTO> saveAppointment(@PathVariable Long companyId, @RequestBody AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.getId());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setAppointmentStatus(AppointmentStatus.TAKEN);
        appointment.setEndTime(appointmentDTO.getEndTime());

        Company company = companyService.getById(companyId);


        if (company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        List<CompanyAdministrator> administrators = appointmentService.findAvailableAdministrator(appointmentDTO.getStartTime(),appointmentDTO.getEndTime(), appointmentDTO.getDate(),companyId);

        for (CompanyAdministrator administrator : administrators) {
            if (administrator.getCompany().getId().equals(companyId)){
                appointment.setAdministrator(administrator);
                break;
            }
        }




        appointment.setStartTime(appointmentDTO.getStartTime());

        appointmentService.save(appointment);

        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.CREATED);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<AppointmentDTO> update(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO){
        Optional<Appointment> appointmentOptional = appointmentService.findById(id);

        Appointment appointment = appointmentOptional.get();

        appointment.setAppointmentStatus(AppointmentStatus.TAKEN);

        appointmentService.save(appointment);

        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.OK);


    }
}

