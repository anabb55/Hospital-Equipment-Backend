package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;
import com.ISAproject.hospitalequipment.repository.ReservationEquipmentStockRepo;
import com.ISAproject.hospitalequipment.service.EquipmentService;
import com.ISAproject.hospitalequipment.service.EquipmentStockService;
import com.ISAproject.hospitalequipment.service.ReservationEquipmentStockService;
import com.ISAproject.hospitalequipment.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationEquipmentStockServiceImpl implements ReservationEquipmentStockService {

    @Autowired
    private ReservationEquipmentStockRepo reservationEquipmentStockRepo;

    @Autowired
    private EquipmentStockService equipmentStockService;

    @Autowired
    private ReservationService reservationService;



    public ReservationEquipmentStock save(List<Equipment> equipments, ReservationEquipmentStock reservationEqStock,Long companyId) {
        Reservation lastReservation = reservationService.getLast();

        Map<Long, Long> equipmentAmountMap = new HashMap<>();
        List<EquipmentStock> allStocks=equipmentStockService.getAll();
        List<EquipmentStock> stocks=new ArrayList<>();
        for(Equipment eq:equipments)
        {
            for(EquipmentStock eqStock:allStocks)
            {
                if(eqStock.getEquipment().id.equals(eq.getId()) && eqStock.getCompany().getId().equals(companyId))
                {
                    stocks.add(eqStock);
                }
            }

        }

        for (EquipmentStock eqStock : stocks) {
            EquipmentStock existingEqStock = equipmentStockService.findById(eqStock.getId());

            if (existingEqStock != null && existingEqStock.getId().equals(eqStock.getId())) {
                Long currentAmount = equipmentAmountMap.getOrDefault(eqStock.getId(), 0L);
                equipmentAmountMap.put(eqStock.getId(), currentAmount + existingEqStock.getAmount());
                ReservationEquipmentStock newReservationEqStock = new ReservationEquipmentStock();
                newReservationEqStock.setAmount(equipmentAmountMap.get(eqStock.getId()));
                newReservationEqStock.setEquipmentStock(eqStock);
                newReservationEqStock.setReservation(lastReservation);

                reservationEquipmentStockRepo.save(newReservationEqStock);

                equipmentAmountMap.put(eqStock.getId(), 1L);
            } else {
                ReservationEquipmentStock newReservationEqStock = new ReservationEquipmentStock();
                newReservationEqStock.setAmount(1L);
                newReservationEqStock.setEquipmentStock(eqStock);
                newReservationEqStock.setReservation(lastReservation);

                reservationEquipmentStockRepo.save(newReservationEqStock);

                equipmentAmountMap.put(eqStock.getId(), 1L);
            }
        }

        return reservationEqStock;
    }



}

