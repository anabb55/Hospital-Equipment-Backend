package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="companyAdministrators")
@Setter
@Getter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = CompanyAdministrator.class)
public class CompanyAdministrator extends User{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    private Company company;

    public CompanyAdministrator(){}

    public CompanyAdministrator(String email, String password, String firstName, String lastName, String phoneNumber, String occupation, boolean enabled, Address address, Company company) {
        super(email, password, firstName, lastName, phoneNumber, occupation, enabled, address);
        this.company = company;
    }

}
