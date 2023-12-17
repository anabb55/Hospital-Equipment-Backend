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

    @Query("SELECT es.amount FROM EquipmentStock es WHERE es.company.id = :companyId and es.equipment.id = :equipmentId")
    Integer findAmountByCompanyAndEquipment(@Param("companyId") Long companyId,@Param("equipmentId") Long equipmentId);

    @Query("SELECT es FROM EquipmentStock es WHERE es.equipment.id = :equipmentId AND es.company.id = :companyId")
    EquipmentStock findByEquipmentIdAndCompanyId(@Param("equipmentId") Long equipmentId, @Param("companyId") Long companyId);

    @Query("DELETE FROM EquipmentStock es WHERE es.id = :equipmentStockId")
    void deleteEquipmentStockById(Long equipmentStockId);
}
