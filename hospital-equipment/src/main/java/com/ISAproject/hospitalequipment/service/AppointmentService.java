package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {
    List<Appointment> getFreeAppointmentsByCompany(Long companyId);

    List<Appointment>findAll();

    List<Appointment>generateRandomAppointments(Long companyId,LocalDate date);
    List<Appointment> findTakenAppointmentsByCompanyAndDate(Long companyId,LocalDate date);
//    public List<Appointment> findByAdministratorAndDate(CompanyAdministrator administrator, LocalDate date) ;

    Appointment save(Appointment appointment);

    Appointment createExtraOrdinaryAppointment(Appointment appointment, AppointmentDTO appointmentDTO);

    public List<CompanyAdministrator> findAvailableAdministrator(LocalTime startTime, LocalTime endTime, LocalDate date,Long companyId);


}
