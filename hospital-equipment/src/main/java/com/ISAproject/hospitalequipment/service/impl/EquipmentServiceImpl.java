package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.repository.EquipmentRepo;
import com.ISAproject.hospitalequipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    public EquipmentRepo equipmentRepo;
    public List<Equipment> getByCompany(Long companyId){
        return equipmentRepo.findByCompany(companyId);
    }
}
