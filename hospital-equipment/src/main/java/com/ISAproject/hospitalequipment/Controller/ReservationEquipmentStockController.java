package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.*;
import com.ISAproject.hospitalequipment.domain.enums.ReservationStatus;
import com.ISAproject.hospitalequipment.dto.RegisterUserDTO;
import com.ISAproject.hospitalequipment.dto.ReservationDTO;
import com.ISAproject.hospitalequipment.dto.ReservationEqRequest;
import com.ISAproject.hospitalequipment.dto.ReservationEquipmentStockDTO;
import com.ISAproject.hospitalequipment.service.ReservationEquipmentStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @CrossOrigin(origins = "*")
    @GetMapping("/getByCompanyId/{companyId}")
    public ResponseEntity<List<ReservationEquipmentStockDTO>> getByCompanyId(@PathVariable("companyId") Long companyId){

        List<ReservationEquipmentStock> reservations= reservationEquipmentStockService.getByCompanyId(companyId);
        List<ReservationEquipmentStockDTO> reservationDTOs= new ArrayList<>();

        for(ReservationEquipmentStock r: reservations){
            if(r.getReservation().getReservationStatus()== ReservationStatus.RESERVED){

                reservationDTOs.add(new ReservationEquipmentStockDTO(r));
            }
        }

        return new ResponseEntity<>(reservationDTOs,HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getUsersReserved/{companyId}")
    public ResponseEntity<List<RegisterUserDTO>> getUsersReserved(@PathVariable("companyId") Long companyId){

        List<ReservationEquipmentStock> reservations= reservationEquipmentStockService.getByCompanyId(companyId);
        List<ReservationEquipmentStockDTO> reservationDTOs= new ArrayList<>();
        List<RegisterUserDTO> registeredUsersDTO= new ArrayList<>();
        for(ReservationEquipmentStock r: reservations){


               registeredUsersDTO.add(new RegisterUserDTO(r.getReservation().getRegisteredUser()));
               registeredUsersDTO.stream().distinct();

        }

        return new ResponseEntity<>(registeredUsersDTO,HttpStatus.OK);
    }

}
