package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Equipment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipmentDTO {
    private Long id;
    private String name;
    private String description;
    private Double grade;
    private Long amount;

    public EquipmentDTO(Long id, String name, String description, Double grade, Long amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.grade = grade;
        this.amount = amount;
    }

    public EquipmentDTO(Equipment equipment)
    {
        this.id=equipment.getId();
        this.name=equipment.getName();
        this.amount=equipment.getAmount();
        this.description=equipment.getDescription();
        this.grade=equipment.getGrade();
    }

    public EquipmentDTO(){}
}
