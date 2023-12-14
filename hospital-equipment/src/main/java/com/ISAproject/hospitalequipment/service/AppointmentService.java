package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    List<Appointment> findFreeAppointmentsByCompanyAndDate(Long companyId, LocalDate date);

    List<Appointment>findAll();

    List<Appointment>generateRandomAppointments(Long companyId,LocalDate date);

}
