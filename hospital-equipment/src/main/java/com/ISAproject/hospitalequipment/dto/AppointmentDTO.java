package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.ISAproject.hospitalequipment.domain.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AppointmentDTO {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;



    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime startTime;


    private AppointmentStatus appointmentStatus;

    private CompanyAdministratorDTO companyAdministrator;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    public LocalTime endTime;

    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.date = appointment.getDate();
        this.endTime=appointment.getEndTime();
        this.startTime = appointment.getStartTime();
        this.appointmentStatus=appointment.getAppointmentStatus();
        if (appointment.getAdministrator() != null) {

            this.companyAdministrator = new CompanyAdministratorDTO(appointment.getAdministrator());
        }
    }

    public AppointmentDTO(Long id, LocalDate date, LocalTime endTime, LocalTime startTime, AppointmentStatus appointmentStatus, CompanyAdministratorDTO companyAdministrator) {
        this.id = id;
        this.date = date;
        this.endTime=endTime;
        this.startTime = startTime;
        this.appointmentStatus = appointmentStatus;
        this.companyAdministrator = companyAdministrator;
    }

    public AppointmentDTO()
    {

    }

}
