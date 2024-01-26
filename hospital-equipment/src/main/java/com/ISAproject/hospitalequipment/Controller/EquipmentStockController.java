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
    @CrossOrigin(origins = "*")

    @PostMapping(value = "/create")
    public ResponseEntity<EquipmentStock> createEquipmentStock(@RequestBody EquipmentStock equipmentStock){
        EquipmentStock newEquipmentStock=  this.equipmentStockService.create(equipmentStock);

        return new ResponseEntity<>(equipmentStock, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")

    @GetMapping(value = "/equipmentByCompany/{id}")
    public ResponseEntity<List<Equipment>> getEquipmentsByCompany(@PathVariable("id")Long companyId){
        List<Equipment> equipmentsByCompany= this.equipmentStockService.findEquipmentsByCompany(companyId);
        return new ResponseEntity<>(equipmentsByCompany,HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")

    @GetMapping(value = "/equipmentAmount/{companyId}/{equipmentId}")
    public ResponseEntity<Integer> getEquipmentAmountByCompany(@PathVariable("companyId") Long companyId,@PathVariable("equipmentId") Long equipmentId){
        Integer amount= this.equipmentStockService.findEquipmentAmountByCompany(companyId, equipmentId);
        return new ResponseEntity<>(amount,HttpStatus.OK);

    }

    @CrossOrigin(origins = "*")
    @PostMapping (value = "/update/{eqId}/{comId}")
    public ResponseEntity<Void> updateAmount(@PathVariable("eqId") Long equipmentId,@PathVariable("comId")  Long comapnyId,@RequestParam("amount") Long amount){
        this.equipmentStockService.updateAmount(equipmentId,comapnyId,amount);

        return new ResponseEntity<>( HttpStatus.OK);
    }


    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/delete/{comId}/{eqId}")
    public ResponseEntity<Long> deleteEquipmentStock(@PathVariable("eqId") Long equipmentId,@PathVariable("comId")  Long comapnyId){
        Long id= this.equipmentStockService.deleteEquipmentStock(comapnyId,equipmentId);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
