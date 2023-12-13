package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.repository.EquipmentStockRepo;
import com.ISAproject.hospitalequipment.service.EquipmentService;
import com.ISAproject.hospitalequipment.service.EquipmentStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentStockServiceImpl implements EquipmentStockService {

    @Autowired
    public EquipmentStockRepo equipmentStockRepo;
    public EquipmentStock create(EquipmentStock equipmentStock){
        return this.equipmentStockRepo.save(equipmentStock);
    }
}
