package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment> getFreeAppointmentsByCompany(Long companyId);

    List<Appointment>findAll();

    List<Appointment>generateRandomAppointments(Long companyId,LocalDate date);
    List<Appointment> findTakenAppointmentsByCompanyAndDate(Long companyId,LocalDate date);

    Optional<Appointment> findById(Long id);

    Appointment save(Appointment appointment);

    Appointment createExtraOrdinaryAppointment(Appointment appointment, AppointmentDTO appointmentDTO);

    public List<CompanyAdministrator> findAvailableAdministrator(LocalTime startTime, LocalTime endTime, LocalDate date,Long companyId);

    public List<Appointment> findFutureAppointmentsByUserId(Long userId);



}
