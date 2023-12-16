package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationEquipmentStockRepo  extends JpaRepository<ReservationEquipmentStock, Long> {

}
