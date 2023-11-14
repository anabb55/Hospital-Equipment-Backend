package com.ISAproject.hospitalequipment.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="Appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    public long Id;

    @NotEmpty
    public String AdminName;

    @NotEmpty
    public String AdminLastName;

    @NotEmpty
    public Date Date;

    @NotNull
    public Integer Duration;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_profile_id")
    private CompanyProfile company;

    public Appointment() {

    }


}
