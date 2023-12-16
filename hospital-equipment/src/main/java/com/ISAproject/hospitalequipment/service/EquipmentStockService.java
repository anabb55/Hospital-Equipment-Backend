package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;

import java.util.List;

public interface EquipmentStockService {

    public EquipmentStock create(EquipmentStock equipmentStock);

    public List<Equipment> findEquipmentsByCompany(Long companyId);

    Integer findEquipmentAmountByCompany(Long companyId,Long equipmentId);

    public void updateAmount(Long equipmentId, Long companyId, Long newAmount);
}
