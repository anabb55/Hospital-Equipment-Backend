package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.service.EquipmentStockService;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/equipmentStocks")
public class EquipmentStockController {

    @Autowired
    public EquipmentStockService equipmentStockService;

    @PostMapping(value = "/create")
    public ResponseEntity<EquipmentStock> createEquipmentStock(@RequestBody EquipmentStock equipmentStock){
        EquipmentStock newEquipmentStock=  this.equipmentStockService.create(equipmentStock);

        return new ResponseEntity<>(equipmentStock, HttpStatus.OK);
    }
}
