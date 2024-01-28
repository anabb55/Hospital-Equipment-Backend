package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.CanceledAppointment;

import java.util.List;

public interface CanceledAppointmentService {

    CanceledAppointment save(CanceledAppointment canceledAppointment);

    List<CanceledAppointment> findAll();
}
