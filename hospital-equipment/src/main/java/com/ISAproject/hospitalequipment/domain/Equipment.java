package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Double grade;

    public Integer amount;

    @OneToMany(mappedBy = "equipment")
    private Set<EquipmentStock> equipmentStock ;

    public Equipment(String name, String description, Double grade, Integer amount, Set<EquipmentStock> equipmentStock) {
        this.name = name;
        this.description = description;
        this.grade = grade;
        this.amount = amount;
        this.equipmentStock = equipmentStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<EquipmentStock> getEquipmentStock() {
        return equipmentStock;
    }

    public void setEquipmentStock(Set<EquipmentStock> equipmentStock) {
        this.equipmentStock = equipmentStock;
    }
}
