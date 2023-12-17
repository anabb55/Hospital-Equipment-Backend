package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;

import java.util.List;

public interface ReservationEquipmentStockService {
    public ReservationEquipmentStock save(List<Equipment> stocks, ReservationEquipmentStock reservation,Long companyId);

}
