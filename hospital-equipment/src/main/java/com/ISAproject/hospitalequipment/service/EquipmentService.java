package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Equipment;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface EquipmentService {

    public List<Equipment> getByCompany(Long companyId);
    public List<Equipment> findEquipmentsByName(String name);

    @Cacheable(cacheNames = "equipment", key = "#name")
    public Equipment  findEquipmentByName(String name);

    @CacheEvict(cacheNames = {"equipment"}, allEntries = true)
    public void removeFromCache() ;
    //returns equipment that Company doesn't possess
    public List<Equipment> findAvailableEquipmentForCompany(Long companyId);

    public List<Equipment> findAll();
}
