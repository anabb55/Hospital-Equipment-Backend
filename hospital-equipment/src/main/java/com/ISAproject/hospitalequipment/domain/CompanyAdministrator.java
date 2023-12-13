package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="companyAdministrators")
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = CompanyAdministrator.class)
public class CompanyAdministrator extends User{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_profile_id")
    private CompanyProfile company;

    @OneToMany(mappedBy = "administrator", cascade = CascadeType.ALL)
    private Set<Appointment> scheduledAppointments = new HashSet<Appointment>();


    public CompanyAdministrator(){}
}
