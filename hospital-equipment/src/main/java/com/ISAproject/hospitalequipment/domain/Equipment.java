package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="equipments")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Equipment {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String description;

    public Double grade;

    public Integer amount;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="company_equipment",
                joinColumns = @JoinColumn(name="equipment_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "company_profile_id", referencedColumnName = "id"))
    public List<CompanyProfile> companies ;

    public Equipment(long id,String name, String description,Double grade,Integer amount){
        this.id = id;
        this.name = name;
        this.description = description;
        this.grade = grade;
        this.amount = amount;
    }
}
