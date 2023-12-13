package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Equipment;

import java.util.List;

public interface EquipmentService {

    public List<Equipment> getByCompany(Long companyId);
    public List<Equipment> findEquipmentByName(String name);
}
