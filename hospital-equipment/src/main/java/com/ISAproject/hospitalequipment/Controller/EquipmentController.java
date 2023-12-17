package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {

    @Autowired
    public EquipmentService equipmentService;

    @GetMapping(value = "/byCompany")
    public ResponseEntity<List<Equipment>> getByCompany(Long companyId){
        List<Equipment> equipmentsByCompany = equipmentService.getByCompany(companyId);
        return new ResponseEntity<>(equipmentsByCompany, HttpStatus.OK) ;
    }
    @GetMapping(value = "/findByName")
    public ResponseEntity<List<Equipment>> findEquipmentByName(String name){
        List<Equipment> equipmentsByName = equipmentService.findEquipmentByName(name);
        return new ResponseEntity<>(equipmentsByName, HttpStatus.OK) ;
    }


    @GetMapping(value = "/findAvailable/{id}")
    public ResponseEntity<List<Equipment>> findAvailableEquipmentForCompany( @PathVariable("id") Long companyId){
        List<Equipment> availableEquipment= equipmentService.findAvailableEquipmentForCompany(companyId);
        return new ResponseEntity<>(availableEquipment, HttpStatus.OK) ;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Equipment>> findAll(){
        List<Equipment> equipments = equipmentService.findAll();
        return new ResponseEntity<>(equipments, HttpStatus.OK) ;
    }

}
