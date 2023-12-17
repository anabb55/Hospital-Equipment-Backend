package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="companyAdministrators")
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CompanyAdministrator extends User{





    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name="company_id")

    private Company company;

    @OneToMany(mappedBy = "administrator", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Appointment> scheduledAppointments = new HashSet<Appointment>();


    public CompanyAdministrator(){}


    public CompanyAdministrator(String email, String password, String firstName, String lastName, String phoneNumber, String occupation, boolean enabled, Address address, Company company) {
        super(email, password, firstName, lastName, phoneNumber, occupation, enabled, address);
        this.company = company;
    }
    public CompanyAdministrator(String email, String password, String firstName, String lastName, String phoneNumber, String occupation, boolean enabled, Address address) {
        super(email, password, firstName, lastName, phoneNumber, occupation, enabled, address);
    }
    public CompanyAdministrator(Long id,String email, String password, String firstName, String lastName, String phoneNumber, String occupation, Address address,Company company) {
        super(email, password, firstName, lastName, phoneNumber, occupation, address);
    }

}
