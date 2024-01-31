package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name="equipments")
public class Equipment implements Serializable {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String description;

    public String type;
    public Double grade;

    public Long amount;
    public Double price;



    @JsonIgnore

    @OneToMany(mappedBy = "equipment", fetch=FetchType.LAZY, cascade = CascadeType.ALL)

    private Set<EquipmentStock> equipmentStocks;

    public Equipment(Long id,String name, String description, String type, Double grade, Long amount,Double price){

        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.grade = grade;
        this.amount = amount;
        this.price = price;
    }
    public Equipment(){}

    public Equipment(Long amount, Double grade, String description, String name) {
        this.name = name;
        this.description = description;
        this.grade = grade;
        this.amount = amount;
    }
}
