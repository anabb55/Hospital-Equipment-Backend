package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EquipmentStockRepo extends JpaRepository<EquipmentStock,Long> {

/*    @Query("SELECT cp FROM EquipmentStock cp JOIN cp.equipment a WHERE a.id = :equipmentId")
    List<EquipmentStock> findByEquipment(@Param("equipmentId") Long equipmentId);
*/

    @Query("SELECT es.equipment FROM EquipmentStock es WHERE es.company.id = :companyId")
    List<Equipment> findEquipmentByCompanyId(@Param("companyId") Long companyId);
}
