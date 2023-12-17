package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.EquipmentStock;
import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationEquipmentStockDTO {
    private Long id;
    private ReservationDTO reservationDTO;
    private EquipmentStockDTO equipmentStockDTO;
    private Long amount;

    public ReservationEquipmentStockDTO(Long id, ReservationDTO reservationDTO, EquipmentStockDTO equipmentStockDTO, Long amount) {
        this.id = id;
        this.reservationDTO = reservationDTO;
        this.equipmentStockDTO = equipmentStockDTO;
        this.amount = amount;
    }

    public ReservationEquipmentStockDTO(ReservationEquipmentStock reservationEquipmentStock)
    {
        this.id=reservationEquipmentStock.getId();
        this.reservationDTO=new ReservationDTO(reservationEquipmentStock.getReservation());
        this.equipmentStockDTO=new EquipmentStockDTO(reservationEquipmentStock.getEquipmentStock());
        this.amount=reservationEquipmentStock.getAmount();
    }

    public ReservationEquipmentStockDTO()
    {

    }



}

