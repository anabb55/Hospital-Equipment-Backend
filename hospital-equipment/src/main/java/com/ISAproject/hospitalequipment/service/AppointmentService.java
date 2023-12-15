package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {
    List<Appointment> findFreeAppointmentsByCompanyAndDate(Long companyId, LocalDate date);

    List<Appointment>findAll();

    List<Appointment>generateRandomAppointments(Long companyId,LocalDate date);
    List<Appointment> findTakenAppointmentsByCompanyAndDate(Long companyId,LocalDate date);

    Appointment save(Appointment appointment);

    Appointment createExtraOrdinaryAppointment(Appointment appointment, AppointmentDTO appointmentDTO);

    public CompanyAdministrator findAvailableAdministrator(LocalTime startTime, LocalTime endTime, LocalDate date);


}
