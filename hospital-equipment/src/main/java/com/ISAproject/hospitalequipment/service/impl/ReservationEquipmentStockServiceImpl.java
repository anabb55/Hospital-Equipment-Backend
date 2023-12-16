package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;
import com.ISAproject.hospitalequipment.repository.ReservationEquipmentStockRepo;
import com.ISAproject.hospitalequipment.service.ReservationEquipmentStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationEquipmentStockServiceImpl implements ReservationEquipmentStockService {

    @Autowired
    private ReservationEquipmentStockRepo reservationEquipmentStockRepo;
    public ReservationEquipmentStock save(ReservationEquipmentStock reservation){
        return reservationEquipmentStockRepo.save(reservation);
    }
}
