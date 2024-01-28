package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.CanceledAppointment;
import com.ISAproject.hospitalequipment.repository.CanceledAppointmentRepo;
import com.ISAproject.hospitalequipment.service.CanceledAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CanceledAppointmentServiceImpl implements CanceledAppointmentService {

    @Autowired
    CanceledAppointmentRepo canceledAppointmentRepo;

    @Override
    public CanceledAppointment save(CanceledAppointment canceledAppointment) {
      return canceledAppointmentRepo.save(canceledAppointment);
    }

    public List<CanceledAppointment> findAll() {
        return canceledAppointmentRepo.findAll();
    }
}
