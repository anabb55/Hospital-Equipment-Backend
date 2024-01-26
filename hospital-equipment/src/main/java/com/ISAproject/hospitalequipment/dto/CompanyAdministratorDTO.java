package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompanyAdministratorDTO extends UserDTO {


   // private Long id;


    private CompanyDTO company;
  
    public CompanyAdministratorDTO() {
    }

  
    public CompanyAdministratorDTO(CompanyAdministrator a) {
        super(
                a.getId(),
                a.getFirstname(),
                a.getLastname(),
                a.getUsername(),
                a.getPassword(),
                a.getEmail(),
                a.getOccupation(),
                a.getAddress(),
                a.getPhoneNumber()
        );
        if(a.getCompany() != null){
            this.company = new CompanyDTO(a.getCompany());
        }

    }

    public CompanyAdministratorDTO(Company company) {
        if(company!=null){
            this.company = new CompanyDTO(company);
        }

    }

}
