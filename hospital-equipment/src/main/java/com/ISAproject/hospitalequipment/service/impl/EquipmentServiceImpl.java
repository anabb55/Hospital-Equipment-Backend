package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.repository.EquipmentRepo;
import com.ISAproject.hospitalequipment.service.EquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {


    @Autowired
    public EquipmentRepo equipmentRepo;
    private final Logger LOG = LoggerFactory.getLogger(CompanyServiceImpl.class);

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
            // If equipment is not found in the cache, it will be fetched from the database.
            // You can log this event as well.
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

}
