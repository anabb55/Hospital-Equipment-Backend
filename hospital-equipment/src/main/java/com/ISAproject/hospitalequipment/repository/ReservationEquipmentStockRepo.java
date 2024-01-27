package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationEquipmentStockRepo  extends JpaRepository<ReservationEquipmentStock, Long> {
    @Query("SELECT res FROM ReservationEquipmentStock res " +
            "JOIN res.equipmentStock e " +
            "WHERE e.company.id = :companyId")
    List<ReservationEquipmentStock> findByCompanyId(@Param("companyId") Long companyId);
}
