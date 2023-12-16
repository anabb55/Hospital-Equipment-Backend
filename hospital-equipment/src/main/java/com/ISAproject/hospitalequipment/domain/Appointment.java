package com.ISAproject.hospitalequipment.domain;
import com.ISAproject.hospitalequipment.dto.AppointmentDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ISAproject.hospitalequipment.domain.enums.AppointmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Appointment.class)
@Table(name="Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    public long id;

//    @NotEmpty
//    public String adminName;
//
//    @NotEmpty
//    public String adminLastName;

    @NotEmpty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate date;


    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    public LocalTime endTime;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime startTime;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="company_profile_id")
//    private CompanyProfile company;


    // @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name="company_id")
    //private Company company;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrator_id")
    private CompanyAdministrator administrator;

    @OneToOne(mappedBy = "appointment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Reservation reservation;

    public Appointment() {

    }

    public Appointment(long id, LocalDate date, LocalTime endTime, LocalTime startTime, AppointmentStatus appointmentStatus) {
        this.id = id;
        this.date = date;
        this.endTime = endTime;
        this.startTime = startTime;
        this.appointmentStatus = appointmentStatus;
    }


}