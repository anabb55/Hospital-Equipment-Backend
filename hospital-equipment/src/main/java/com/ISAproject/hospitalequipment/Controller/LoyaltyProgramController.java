package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.LoyaltyProgram;
import com.ISAproject.hospitalequipment.dto.LoyaltyProgramDTO;
import com.ISAproject.hospitalequipment.service.LoyaltyProgramService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loyaltyProgram")
public class LoyaltyProgramController {

    @Autowired
    LoyaltyProgramService loyaltyProgramService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<LoyaltyProgram>> findAll(){
        List<LoyaltyProgram> loyaltyPrograms = loyaltyProgramService.findAll();
        return new ResponseEntity<>(loyaltyPrograms, HttpStatus.OK) ;
    }


    @CrossOrigin(origins = "*")
    @PutMapping(value = "/update")
    public ResponseEntity<LoyaltyProgramDTO> update(@RequestBody LoyaltyProgramDTO loyaltyProgram){
        LoyaltyProgram program = loyaltyProgramService.findById(loyaltyProgram.getId());
        program.setPointsPerEquipment(loyaltyProgram.getPointsPerEquipment());
        program.setDiscountPercentage(loyaltyProgram.getDiscountPercentage());
         LoyaltyProgram updated = loyaltyProgramService.update(program);
        return new ResponseEntity<>(new LoyaltyProgramDTO(updated), HttpStatus.OK) ;
    }

}