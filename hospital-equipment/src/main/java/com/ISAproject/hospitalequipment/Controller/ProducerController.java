package com.ISAproject.hospitalequipment.Controller;

import com.ISAproject.hospitalequipment.domain.Contract;
import com.ISAproject.hospitalequipment.domain.Producer;
import com.ISAproject.hospitalequipment.domain.enums.ContractStatus;
import com.ISAproject.hospitalequipment.service.ContractService;
import com.ISAproject.hospitalequipment.service.EquipmentStockService;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/api/producer")
public class ProducerController {

    @Autowired
    private Producer producer;



    @Autowired
    private ContractService contractService;

    @Autowired
    private EquipmentStockService equipmentStockService;
/*
    @CrossOrigin(value = "*")
    @PostMapping(value="/{queue}")
    public ResponseEntity<String> sendMessage(@PathVariable("queue") String queue, @RequestBody String message) {
        producer.sendTo(queue, message);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(value = "*")
    @PostMapping(value="/{exchange}/{queue}", consumes = "text/plain")
    public ResponseEntity<String> sendMessageToExchange(@PathVariable("exchange") String exchange, @PathVariable("queue") String queue, @RequestBody String message) {
        producer.sendToExchange(exchange, queue, message);
        return ResponseEntity.ok().build();
    }
    */

    @CrossOrigin(value = "*")
    @GetMapping(value="/checkDelivery")
    public ResponseEntity<String> isDeliveryToday(){
            Contract validContract = contractService.getValidContract();
            if(validContract!=null) {

            if (equipmentStockService.isAmountTooLarge(validContract.getEquipmentType(), validContract.getCompanyId(), validContract.getAmount())) {

                //slucaj da nema dovoljno opreme
                String queue = "deliveryMessage";
                String message = "No enough amount for wanted equipment, contract becomes invalid ";
                producer.sendTo(queue, message);
                validContract.setContractStatus(ContractStatus.INVALID);
                contractService.save(validContract);
                return ResponseEntity.ok().build();

            } else {
                if (contractService.IsDeliveryToday()) {
                    //isporuka danas
                    //umanji kolicinu te opreme u firmi

                    equipmentStockService.updateAmountForContract(validContract.getEquipmentType(), validContract.getCompanyId(), validContract.getAmount());
                    String queue = "spring-boot1";
                    String message = "Your ORDER has been delivered delivered";
                    producer.sendTo(queue, message);
                    validContract.setContractStatus(ContractStatus.INVALID);
                    contractService.save(validContract);
                    return ResponseEntity.ok().build();
                } else {
                    //ima dovoljno opreme u sistemu ali isporuka nije danas
                    return new ResponseEntity<>("No deliveries for today", HttpStatus.OK);
                }


            }
        }else{
                return new ResponseEntity<>("There is no valid contract", HttpStatus.OK);
            }
    }
}
