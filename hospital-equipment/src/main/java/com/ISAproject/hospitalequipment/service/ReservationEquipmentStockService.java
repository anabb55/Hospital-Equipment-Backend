package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;

import java.util.List;

public interface ReservationEquipmentStockService {
    public ReservationEquipmentStock save(List<Equipment> stocks, ReservationEquipmentStock reservation,Long companyId);
    public List<ReservationEquipmentStock> getByCompanyId(Long companyId);

    public ReservationEquipmentStock getById(Long id);

    public ReservationEquipmentStock saveStock(ReservationEquipmentStock resEqStock);

    public List<ReservationEquipmentStock> findByReservationId(Long reservationId);
    public Long totalPrice(Long idAppointment);

    EquipmentStock returnEquipment(Long appointmentId);


}
