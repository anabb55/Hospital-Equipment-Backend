package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;
import com.ISAproject.hospitalequipment.repository.ReservationEquipmentStockRepo;
import com.ISAproject.hospitalequipment.service.EquipmentStockService;
import com.ISAproject.hospitalequipment.service.ReservationEquipmentStockService;
import com.ISAproject.hospitalequipment.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationEquipmentStockServiceImpl implements ReservationEquipmentStockService {

    @Autowired
    private ReservationEquipmentStockRepo reservationEquipmentStockRepo;

    @Autowired
    private EquipmentStockService equipmentStockService;

    @Autowired
    private ReservationService reservationService;



    public ReservationEquipmentStock save(List<Equipment> equipments, ReservationEquipmentStock reservationEqStock, Long companyId) {
        Reservation lastReservation = reservationService.getLast();
        List<EquipmentStock> allStocks = equipmentStockService.getAll();
        List<EquipmentStock> filteredStocks = new ArrayList<>();

        // Filter the stocks based on equipment ID and company ID
        for (Equipment eq : equipments) {
            for(EquipmentStock eqStock : allStocks) {
                if(eqStock.getEquipment().id.equals(eq.getId()) && eqStock.getCompany().getId().equals(companyId)) {
                    filteredStocks.add(eqStock);
                }
            }
        }

        for (EquipmentStock eqStock : filteredStocks) {
            EquipmentStock existingEqStock = equipmentStockService.findById(eqStock.getId());
            ReservationEquipmentStock newReservationEqStock = new ReservationEquipmentStock();

            // Set the amount and equipment stock
            newReservationEqStock.setAmount(existingEqStock != null ? existingEqStock.getAmount() : 1L);
            newReservationEqStock.setEquipmentStock(eqStock);
            newReservationEqStock.setReservation(lastReservation);

            newReservationEqStock.setTotalPrice(eqStock.getPrice());


            reservationEquipmentStockRepo.save(newReservationEqStock);
        }

        return reservationEqStock;
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

