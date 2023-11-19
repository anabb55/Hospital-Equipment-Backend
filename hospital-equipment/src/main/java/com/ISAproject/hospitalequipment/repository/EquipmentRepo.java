package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment,Long> {
    @Query(value = "SELECT * FROM equipments e1 INNER JOIN company_equipment e2 ON e1.id = e2.equipment_id WHERE e2.company_profile_id = ?1 ", nativeQuery = true)
    List<Equipment> findByCompany(Long companyId);

    List<Equipment> findEquipmentByName(String name);
}
