package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.service.EquipmentStockService;
import com.sun.mail.iap.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/equipmentByCompany/{id}")
    public ResponseEntity<List<Equipment>> getEquipmentsByCompany(@PathVariable("id")Long companyId){
        List<Equipment> equipmentsByCompany= this.equipmentStockService.findEquipmentsByCompany(companyId);
        return new ResponseEntity<>(equipmentsByCompany,HttpStatus.OK);
    }
}
