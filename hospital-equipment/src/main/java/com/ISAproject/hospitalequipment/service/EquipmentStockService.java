package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;

import java.util.List;

public interface EquipmentStockService {

    public EquipmentStock create(EquipmentStock equipmentStock);

    public List<Equipment> findEquipmentsByCompany(Long companyId);

    Integer findEquipmentAmountByCompany(Long companyId,Long equipmentId);


    public void updateAmount(Long equipmentId, Long companyId, Long newAmount);

    public EquipmentStock  findById(Long id);

    public List<EquipmentStock> getAll();

  

    public Long deleteEquipmentStock(Long companyId, Long equipmentId);

    public void updateAmountForContract(String equipmentName, Long companyId, Long amountWanted);

    public boolean isAmountTooLarge(String equipmentName, Long companyId, Long amountWanted);


}
