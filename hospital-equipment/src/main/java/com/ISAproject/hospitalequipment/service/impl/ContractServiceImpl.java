package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Contract;
import com.ISAproject.hospitalequipment.domain.enums.ContractStatus;
import com.ISAproject.hospitalequipment.repository.ContractRepository;
import com.ISAproject.hospitalequipment.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    public ContractRepository contractRepo;
    public Boolean IsDeliveryToday(){
        if(contractRepo.existsByDateAndStatus(LocalDate.now(), ContractStatus.VALID)){
            return true;
        }else{
            return false;
        }
    }
    public Object[] findLongitudeLatitudeOfLatestContract(){
        return contractRepo.findLongitudeLatitudeOfLatestContract();
    }

    public Contract getValidContract(){
        return contractRepo.getValidContract(ContractStatus.VALID);
    }

    public Contract save(Contract contract){
        return contractRepo.save(contract);
    }
}
