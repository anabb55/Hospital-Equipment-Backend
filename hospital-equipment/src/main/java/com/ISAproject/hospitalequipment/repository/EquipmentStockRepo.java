package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentStockRepo extends JpaRepository<EquipmentStock,Long> {


}
