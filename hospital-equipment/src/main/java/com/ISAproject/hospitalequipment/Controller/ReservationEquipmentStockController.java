package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;
import com.ISAproject.hospitalequipment.dto.ReservationEqRequest;
import com.ISAproject.hospitalequipment.dto.ReservationEquipmentStockDTO;
import com.ISAproject.hospitalequipment.service.ReservationEquipmentStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservationEquipment")
public class ReservationEquipmentStockController {

    @Autowired
    private ReservationEquipmentStockService reservationEquipmentStockService;

    @CrossOrigin(origins = "*")
    @PostMapping("/processReservation")
    public ResponseEntity<ReservationEquipmentStockDTO> processReservation(
            @RequestBody ReservationEqRequest request) {
        ReservationEquipmentStockDTO reservationEquipmentStockDTO = request.getReservationEquipmentStockDTO();
        List<Equipment> stocks = request.getStocks();
        Long companyId = request.getCompanyId();

        ReservationEquipmentStock reservationEquipmentStock = new ReservationEquipmentStock();
        reservationEquipmentStock.setAmount(1L);
        reservationEquipmentStockService.save(stocks, reservationEquipmentStock,companyId);

        return new ResponseEntity<>(new ReservationEquipmentStockDTO(reservationEquipmentStock), HttpStatus.CREATED);
    }


}
