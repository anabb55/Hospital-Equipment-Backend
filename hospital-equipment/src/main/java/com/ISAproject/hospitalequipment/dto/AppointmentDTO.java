package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    private Integer duration;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime startTime;

    private Long companyId;

    private AppointmentStatus appointmentStatus;

    private Long administratorId;


    public AppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.date = appointment.getDate();
        this.duration = appointment.getDuration();
        this.startTime = appointment.getStartTime();
        if (appointment.getCompany() != null) {
            this.companyId = appointment.getCompany().getId();
        }
        this.appointmentStatus=appointment.getAppointmentStatus();

    }
}
