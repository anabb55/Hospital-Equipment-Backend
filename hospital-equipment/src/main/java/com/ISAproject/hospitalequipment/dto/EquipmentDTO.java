package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class EquipmentDTO {


    public Long id;

    public String name;

    public String description;

    public Double grade;

    public Integer amount;
    private Set<EquipmentStock> equipmentStocks;
    public EquipmentDTO(Equipment e){
        this(e.getId(),e.getName(),e.getDescription(),e.getGrade(),e.getAmount());
    }

    public EquipmentDTO(Long id, String name, String description, Double grade, Integer amount) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.amount = amount;
        this.description = description;
    }
}
