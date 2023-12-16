package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.service.ReservationEquipmentStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservationEquipment")
public class ReservationEquipmentStockController {

    @Autowired
    private ReservationEquipmentStockService reservationEquipmentStockService;


}
