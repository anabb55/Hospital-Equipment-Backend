package com.ISAproject.hospitalequipment.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="equipments")
public class Equipment {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="company_equipment",
                joinColumns = @JoinColumn(name="equipment_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "company_profile_id", referencedColumnName = "id"))
    public List<CompanyProfile> companies ;

}
