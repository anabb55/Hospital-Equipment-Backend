package com.ISAproject.hospitalequipment.service.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.repository.EquipmentRepo;
import com.ISAproject.hospitalequipment.service.EquipmentService;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final Logger LOG = LoggerFactory.getLogger(CompanyServiceImpl.class);

    @Autowired
    public EquipmentRepo equipmentRepo;
    @Autowired
    public RegisteredUserService registeredUserService;
    public List<Equipment> getByCompany(Long companyId){
        return equipmentRepo.findByCompany(companyId);
    }
    public List<Equipment> findEquipmentsByName(String name){

        return equipmentRepo.findEquipmentsByName(name);
    }
    public void removeFromCache() {
        LOG.info("Equipments removed from cache!");

    }
    public Equipment findEquipmentByName(String name) {
        LOG.info("------------------------IZVLACENJE IZ BAZE-----------------------------------");

        LOG.info("Entering findEquipmentByName for name: {}", name);
        Equipment equipment = equipmentRepo.findEquipmentByName(name);

        if (equipment != null) {
            LOG.info("Equipment is cached - Name: {}, ID: {}, Amount: {},Description:{},Grade:{} ",
                    equipment.getName(), equipment.getId(), equipment.getAmount(),equipment.getDescription(),equipment.getGrade());        } else {
            LOG.info("Equipment not found in cache for name: {}", name);
        }

        LOG.info("Exiting findEquipmentByName");
        return equipment;
    }


    public List<Equipment> findAvailableEquipmentForCompany(Long companyId) {
        return this.equipmentRepo.findMissingEquipmentForCompany(companyId);
    }


    @Override
    public List<Equipment> findAll() {
        return equipmentRepo.findAll();
    }

    @Override
    public Equipment update(Equipment e,Long userId) {
        RegisteredUser user = registeredUserService.findById(userId).get();
        e.setPrice(e.getPrice()- e.getPrice()*user.getLoyaltyProgram().getDiscountPercentage());
        return equipmentRepo.save(e);
    }

}
