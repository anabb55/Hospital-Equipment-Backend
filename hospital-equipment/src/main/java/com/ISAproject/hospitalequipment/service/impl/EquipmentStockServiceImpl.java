package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;
import com.ISAproject.hospitalequipment.repository.EquipmentStockRepo;
import com.ISAproject.hospitalequipment.service.AppointmentService;
import com.ISAproject.hospitalequipment.service.EquipmentStockService;
import com.ISAproject.hospitalequipment.service.ReservationEquipmentStockService;
import com.ISAproject.hospitalequipment.service.ReservationService;
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


    public EquipmentStock save(EquipmentStock eqStock) {
        return equipmentStockRepo.save(eqStock);
    }

    public List<EquipmentStock> getAll()
    {
        return this.equipmentStockRepo.findAll();
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


    public EquipmentStock findById(Long id){
        return equipmentStockRepo.findById(id).get();
    }


    public Long deleteEquipmentStock(Long companyId, Long equipmentId){
        EquipmentStock eqStock = this.equipmentStockRepo.findByEquipmentIdAndCompanyId(equipmentId,companyId);

        this.equipmentStockRepo.deleteById(eqStock.getId());
        //this.equipmentStockRepo.delete(eqStock);
        return eqStock.getId();
    }

    public void updateAmountForContract(String equipmentName, Long companyId, Long amountWanted) {
        EquipmentStock oldEquipmentStock = equipmentStockRepo.findByEquipmentNameAndCompanyId(equipmentName, companyId);
        Long newAmount= oldEquipmentStock.getAmount()- amountWanted;
        if (oldEquipmentStock!=null) {
            oldEquipmentStock.setAmount(newAmount);
            equipmentStockRepo.save(oldEquipmentStock);
        } else {

            throw new RuntimeException("EquipmentStock not found for given equipment and company");
        }
    }




    public boolean isAmountTooLarge(String equipmentName, Long companyId, Long amountWanted) {
        EquipmentStock oldEquipmentStock = equipmentStockRepo.findByEquipmentNameAndCompanyId(equipmentName, companyId);
        Long newAmount= oldEquipmentStock.getAmount()- amountWanted;

        if(newAmount<0){
            return true;
        }else{
            return false;
        }

    }

}
