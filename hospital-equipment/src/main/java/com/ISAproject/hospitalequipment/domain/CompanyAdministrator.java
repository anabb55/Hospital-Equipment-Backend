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
    @JoinColumn(name="company_profile_id")
    private CompanyProfile company;

    public CompanyAdministrator(){}
}
