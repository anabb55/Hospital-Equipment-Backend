package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;
import com.ISAproject.hospitalequipment.repository.ReservationEquipmentStockRepo;
import com.ISAproject.hospitalequipment.service.EquipmentStockService;
import com.ISAproject.hospitalequipment.service.ReservationEquipmentStockService;
import com.ISAproject.hospitalequipment.service.ReservationService;
import jakarta.persistence.OptimisticLockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


@Transactional
    public ReservationEquipmentStock save(List<Equipment> equipments, ReservationEquipmentStock reservationEqStock, Long companyId) {
    try { Reservation lastReservation = reservationService.getLast();
        List<EquipmentStock> allStocks = equipmentStockService.getAll();
        Map<Long, Integer> equipmentCount = new HashMap<>();

        for (Equipment eq : equipments) {
            equipmentCount.put(eq.getId(), equipmentCount.getOrDefault(eq.getId(), 0) + 1);
        }

        for (EquipmentStock eqStock : allStocks) {
            if (equipmentCount.containsKey(eqStock.getEquipment().getId()) &&
                    eqStock.getCompany().getId().equals(companyId)) {

                int count = equipmentCount.get(eqStock.getEquipment().getId());
                EquipmentStock existingEqStock = equipmentStockService.findById(eqStock.getId());


                if (existingEqStock.getAmount() >= count) {
                    existingEqStock.setAmount(existingEqStock.getAmount() - count);
                    equipmentStockService.save(existingEqStock);


                    ReservationEquipmentStock newReservationEqStock = new ReservationEquipmentStock();
                    newReservationEqStock.setAmount((long) count);
                    newReservationEqStock.setEquipmentStock(eqStock);
                    newReservationEqStock.setReservation(lastReservation);
                    newReservationEqStock.setTotalPrice(eqStock.getPrice() * count);

                    reservationEquipmentStockRepo.save(newReservationEqStock);
                } else {
                   return null;
                }
            }
        }

        return reservationEqStock;}
    catch (OptimisticLockException e) {
        throw new RuntimeException("Conflict occurred. Please retry.", e);
    }

    }




    public List<ReservationEquipmentStock> getByCompanyId(Long companyId){
        return reservationEquipmentStockRepo.findByCompanyId(companyId);
    }

    public ReservationEquipmentStock getById(Long id){
        return  reservationEquipmentStockRepo.findById(id).get();
    }

    public ReservationEquipmentStock saveStock(ReservationEquipmentStock resEqStock){
        return reservationEquipmentStockRepo.save(resEqStock);
    }

    @Override
    public List<ReservationEquipmentStock> findByReservationId(Long reservationId) {
        return reservationEquipmentStockRepo.findByReservationId(reservationId);
    }


    public Long totalPrice(Long idAppointment){
    return reservationEquipmentStockRepo.sumTotalPriceForAppointment(idAppointment);
    }

}

