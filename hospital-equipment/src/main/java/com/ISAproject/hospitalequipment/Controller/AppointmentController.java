package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Company;

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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private CompanyService companyService;
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
        appointment.setDuration(appointmentDTO.getDuration());

        Company company = companyService.getById(companyId);

        if (company == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        CompanyAdministrator administrator = appointmentService.findAvailableAdministrator(company.getWorkStartTime(), company.getWorkEndTime(), appointmentDTO.getDate());

        if (administrator == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        appointment.setAdministrator(administrator);
        appointment.setStartTime(appointmentDTO.getStartTime());

        appointmentService.save(appointment);

        return new ResponseEntity<>(new AppointmentDTO(appointment), HttpStatus.CREATED);
    }
}

