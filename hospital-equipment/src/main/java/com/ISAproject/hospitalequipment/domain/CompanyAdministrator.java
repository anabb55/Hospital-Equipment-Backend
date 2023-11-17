package com.ISAproject.hospitalequipment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="companyAdministrators")
@Setter
@Getter
public class CompanyAdministrator extends User{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="company_profile_id")
    private CompanyProfile company;

    public CompanyAdministrator(){}
}
