package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.CanceledAppointment;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.dto.CanceledAppointmentDTO;
import com.ISAproject.hospitalequipment.dto.CompanyAdministratorDTO;
import com.ISAproject.hospitalequipment.service.CanceledAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/canceledAppointments")
public class CanceledAppointmentController {

    @Autowired
    public CanceledAppointmentService canceledAppointmentService;

    @GetMapping("/")
    public ResponseEntity<List<CanceledAppointmentDTO>> findAll() {

        List<CanceledAppointment> canceledAppointments = canceledAppointmentService.findAll();
        List<CanceledAppointmentDTO> canceledAppointmentDTOS = new ArrayList<>();

        for (CanceledAppointment s : canceledAppointments) {
            canceledAppointmentDTOS.add(new CanceledAppointmentDTO(s));
        }


        return new ResponseEntity<>(canceledAppointmentDTOS, HttpStatus.OK);
    }
}
