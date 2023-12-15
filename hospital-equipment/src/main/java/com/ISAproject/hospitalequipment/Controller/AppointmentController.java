package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import com.ISAproject.hospitalequipment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @GetMapping("/generateRandomAppointments/{companyId}")
    public ResponseEntity<List<AppointmentDTO>> generateRandomAppointments(
            @PathVariable Long companyId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        List<Appointment> generatedAppointments = appointmentService.generateRandomAppointments(companyId, date);

        List<AppointmentDTO> appointmentDTOs = generatedAppointments.stream()
                .map(AppointmentDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(appointmentDTOs, HttpStatus.OK);
    }
}

