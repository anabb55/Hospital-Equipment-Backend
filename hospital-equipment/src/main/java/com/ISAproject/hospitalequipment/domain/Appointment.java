package com.ISAproject.hospitalequipment.domain;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ISAproject.hospitalequipment.domain.enums.AppointmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
    public Date date;

    @NotNull
    public Integer duration;


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="company_profile_id")
//    private CompanyProfile company;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="working_calender_id")
    private WorkingTimeCalender workingTimeCalender;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;

    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private CompanyAdministrator administrator;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Reservation reservation;
    public Appointment() {

    }


}

