package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.*;
import com.ISAproject.hospitalequipment.domain.enums.AppointmentStatus;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import com.ISAproject.hospitalequipment.repository.AppointmentRepo;
import com.ISAproject.hospitalequipment.service.AppointmentService;
import com.ISAproject.hospitalequipment.service.CompanyAdministratorService;
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

    @Autowired
    private CompanyAdministratorService companyAdministratorService;


    public List<Appointment> findFreeAppointmentsByCompanyAndDate(Long companyId, LocalDate date) {
        return appointmentRepo.findFreeAppointmentsByCompanyAndDate(companyId, date);


    }

    public Appointment createExtraOrdinaryAppointment(Appointment appointment, AppointmentDTO appointmentDTO){




        return appointmentRepo.save(appointment);

    }
//    public List<Appointment> findByAdministratorAndDate(CompanyAdministrator administrator, LocalDate date) {
//        return appointmentRepo.findByAdministratorAndDate(administrator,date);
//    }
    public List<CompanyAdministrator> findAvailableAdministrator(LocalTime startTime, LocalTime endTime, LocalDate date,Long companyId){
        return  companyAdministratorService.findAvailableAdministrator(startTime,endTime,date,companyId);
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public List<Appointment> findAll() {
        return appointmentRepo.findAll();
    }

    public List<Appointment> findTakenAppointmentsByCompanyAndDate(Long companyId, LocalDate date) {
        return appointmentRepo.findTakenAppointmentsByCompanyAndDate(companyId, date);
    }
    public long getMaxAppointmentId() {
        List<Appointment> allAppointments = findAll();

        return allAppointments.stream()
                .mapToLong(Appointment::getId)
                .max()
                .orElse(1);
    }
    public long increaseAppointmentId(){
        long id=getMaxAppointmentId();
        return ++id;
    }




    public List<Appointment> generateRandomAppointments(Long companyId, LocalDate date) {
        List<Appointment> takenAppointments = findTakenAppointmentsByCompanyAndDate(companyId, date);
        long nextId=increaseAppointmentId();
        List<Appointment> generatedAppointments = new ArrayList<>();
        Company company = companyService.getById(companyId);
        LocalTime startWorkingTime = company.getWorkStartTime();
        LocalTime endWorkingTime = company.getWorkEndTime();
        LocalTime duration = LocalTime.of(2, 30);
        List<LocalTime> takenTimes = takenAppointments.stream()
                .map(Appointment::getStartTime)
                .toList();

        while (startWorkingTime.plusHours(duration.getHour()).plusMinutes(duration.getMinute()).plusSeconds(duration.getSecond()).isBefore(endWorkingTime)) {
            LocalTime currentStartTime = startWorkingTime;
            LocalTime currentEndTime = startWorkingTime.plusHours(2);

            boolean isTimeSlotFree = takenTimes.stream()
                    .noneMatch(takenTime -> takenTime.isBefore(currentEndTime) && takenTime.plusHours(duration.getHour()).plusMinutes(duration.getMinute()).plusSeconds(duration.getSecond()).isAfter(currentStartTime));

            if (isTimeSlotFree) {
                Appointment appointment = new Appointment();
                appointment.setId(nextId);
                appointment.setDate(date);
                appointment.setStartTime(currentStartTime);
                appointment.setEndTime(currentEndTime);
                appointment.setAppointmentStatus(AppointmentStatus.EXTRAORDINARY);
                generatedAppointments.add(appointment);

            }

            startWorkingTime = startWorkingTime.plusHours(duration.getHour()).plusMinutes(duration.getMinute()).plusSeconds(duration.getSecond());
        }
        return generatedAppointments;
    }

    public void createApp(LocalDate date, LocalTime startTime,LocalTime endTime,Long adminId, Long id, String status ){
        this.appointmentRepo.insertAppointment(date,startTime,endTime,adminId,id,status);
    }
}
