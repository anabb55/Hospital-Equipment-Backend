package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.enums.AppointmentStatus;
import com.ISAproject.hospitalequipment.repository.AppointmentRepo;
import com.ISAproject.hospitalequipment.service.AppointmentService;
import com.ISAproject.hospitalequipment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service

public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private CompanyService companyService;





    public List<Appointment> findFreeAppointmentsByCompanyAndDate(Long companyId, LocalDate date){
        return appointmentRepo.findFreeAppointmentsByCompanyAndDate(companyId,date);


    }

    public List<Appointment>findAll()
    {
        return appointmentRepo.findAll();
    }

    public List<Appointment>generateRandomAppointments(Long companyId, LocalDate date) {
        System.out.println("In service: " + companyId + " and date: " + date);

        List<Appointment> existingAppointments = findFreeAppointmentsByCompanyAndDate(companyId, date);
        List<Appointment> allAppointments=findAll();

                 long maxId = allAppointments.stream()
                .mapToLong(Appointment::getId)
                .max()
                .orElse(1);
                 maxId++;
        if (existingAppointments.isEmpty()) {

            List<Appointment> generatedAppointments = new ArrayList<>();
            Company company = companyService.getById(companyId);
            LocalTime startWorkingTime = company.getWorkStartTime();
            LocalTime endWorkingTime = company.getWorkEndTime();
            int duration = 160;

            while (startWorkingTime.plusMinutes(duration).isBefore(endWorkingTime)) {
                Appointment appointment = new Appointment();
                appointment.setId(maxId);
                appointment.setDate(date);
                appointment.setStartTime(startWorkingTime);
                appointment.setDuration(duration);
                appointment.setAppointmentStatus(AppointmentStatus.valueOf("EXTRAORDINARY"));
                appointment.setCompany(company);

                generatedAppointments.add(appointment);

                startWorkingTime = startWorkingTime.plusMinutes(duration);
            }
            return generatedAppointments;
        } else
            return existingAppointments;

    }
}
