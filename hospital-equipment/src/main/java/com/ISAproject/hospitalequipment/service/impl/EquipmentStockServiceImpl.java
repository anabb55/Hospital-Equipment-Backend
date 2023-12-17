package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.repository.EquipmentStockRepo;
import com.ISAproject.hospitalequipment.service.EquipmentService;
import com.ISAproject.hospitalequipment.service.EquipmentStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentStockServiceImpl implements EquipmentStockService {

    @Autowired
    public EquipmentStockRepo equipmentStockRepo;
    public EquipmentStock create(EquipmentStock equipmentStock){
        return this.equipmentStockRepo.save(equipmentStock);
    }
    public List<Equipment> findEquipmentsByCompany(Long companyId){
        return this.equipmentStockRepo.findEquipmentByCompanyId(companyId);
    }

    public Integer findEquipmentAmountByCompany(Long companyId,Long equipmentId){
        return this.equipmentStockRepo.findAmountByCompanyAndEquipment(companyId,equipmentId);
    }

    public void updateAmount(Long equipmentId, Long companyId, Long newAmount) {
        EquipmentStock oldEquipmentStock = equipmentStockRepo.findByEquipmentIdAndCompanyId(equipmentId, companyId);

        if (oldEquipmentStock!=null) {
            oldEquipmentStock.setAmount(newAmount);
            equipmentStockRepo.save(oldEquipmentStock);
        } else {

            throw new RuntimeException("EquipmentStock not found for given equipment and company");
        }
    }

    public Long deleteEquipmentStock(Long companyId, Long equipmentId){
       EquipmentStock eqStock = this.equipmentStockRepo.findByEquipmentIdAndCompanyId(equipmentId,companyId);

        this.equipmentStockRepo.deleteEquipmentStockById(eqStock.getId());
       //this.equipmentStockRepo.delete(eqStock);
       return eqStock.getId();
    }
}
