package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.*;
import com.ISAproject.hospitalequipment.domain.enums.AppointmentStatus;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import com.ISAproject.hospitalequipment.repository.AppointmentRepo;
import com.ISAproject.hospitalequipment.service.*;

import jakarta.persistence.OptimisticLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyAdministratorService companyAdministratorService;

    @Autowired
    private CanceledAppointmentService canceledAppointmentService;

    @Autowired
    private UserService userService;


    public List<Appointment> getFreeAppointmentsByCompany(Long companyId) {
        return appointmentRepo.findFreeAppointmentsByCompany(companyId);


    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Appointment updateStatus(Long id, AppointmentDTO appointmentDTO){

        try{
            Optional<Appointment> appointmentOptional = appointmentRepo.findById(id);

            Appointment appointment = appointmentOptional.get();

            if(appointment.getAppointmentStatus() == AppointmentStatus.PREDEFINED) {
                appointment.setAppointmentStatus(AppointmentStatus.TAKEN);
            }

            appointmentRepo.save(appointment);

            return appointment;

        }catch (OptimisticLockException ex){
            throw  new RuntimeException("Enable to update status");
        }



    }


    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Appointment cancelAppointment(Long id, AppointmentDTO appointmentDTO, Long userId) {

        try{
            Optional<Appointment> appointmentOptional = appointmentRepo.findById(id);

            Appointment appointment = appointmentOptional.get();

            User user = userService.getById(userId);

            if(appointment.getAppointmentStatus()==AppointmentStatus.TAKEN){
                appointment.setAppointmentStatus(AppointmentStatus.PREDEFINED);
                CanceledAppointment canceledAppointment = new CanceledAppointment();
                canceledAppointment.setAppointment(appointment);
                canceledAppointment.setUser(user);
                canceledAppointmentService.save(canceledAppointment);


            }


            appointmentRepo.save(appointment);
            return appointment;

        } catch (OptimisticLockException ex){
          throw  new RuntimeException("enable to update status");
        }


    }


    public Appointment createExtraOrdinaryAppointment(Appointment appointment, AppointmentDTO appointmentDTO){

        return appointmentRepo.save(appointment);

    }

    public List<Appointment> findFutureAppointmentsByUserId(Long userId){
        return appointmentRepo.findFutureAppointmentsByUserId(userId);
    }



    public List<CompanyAdministrator> findAvailableAdministrator(LocalTime startTime, LocalTime endTime, LocalDate date,Long companyId){
        return  companyAdministratorService.findAvailableAdministrator(startTime,endTime,date,companyId);
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Appointment saveAppointment(Long companyId, AppointmentDTO appointmentDTO){
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.getId());
        appointment.setDate(appointmentDTO.getDate());
        appointment.setAppointmentStatus(AppointmentStatus.TAKEN);
        appointment.setEndTime(appointmentDTO.getEndTime());

        Company company = companyService.getById(companyId);


        if (company == null) {
            throw new IllegalStateException("No company found.");
        }


        List<CompanyAdministrator> administrators = findAvailableAdministrator(appointmentDTO.getStartTime(),appointmentDTO.getEndTime(), appointmentDTO.getDate(),companyId);

        if (administrators == null || administrators.isEmpty()) {
            throw new IllegalStateException("No available administrators found.");
        }

        for (CompanyAdministrator administrator : administrators) {
            if (administrator.getCompany().getId().equals(companyId)){
                appointment.setAdministrator(administrator);
                break;
            }
        }




        appointment.setStartTime(appointmentDTO.getStartTime());

        appointmentRepo.save(appointment);

        return appointment;
    }

    public List<Appointment> findAll() {
        return appointmentRepo.findAll();
    }

    public Optional<Appointment> findById(Long id){
        return  appointmentRepo.findById(id);
    }

    public List<Appointment> findTakenAppointmentsByCompanyAndDate(Long companyId, LocalDate date) {
        return appointmentRepo.findTakenAppointmentsByCompanyAndDate(companyId, date);
    }

    public List<Appointment> findTakenAppointmentsByCompany(Long companyId) {
        return appointmentRepo.findTakenAppointmentsByCompany(companyId);
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



    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
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


}
