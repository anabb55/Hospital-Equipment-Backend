package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Contract;

public interface ContractService {

    public Boolean IsDeliveryToday();

    public Contract getValidContract();

    public Contract save(Contract contract);
}
