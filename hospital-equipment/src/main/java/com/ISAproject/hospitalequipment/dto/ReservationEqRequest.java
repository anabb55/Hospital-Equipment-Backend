package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Equipment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReservationEqRequest{
        private ReservationEquipmentStockDTO reservationEquipmentStockDTO;
        private List<Equipment> stocks;
        private Long companyId;

        public ReservationEqRequest(ReservationEquipmentStockDTO reservationEquipmentStockDTO, List<Equipment> stocks, Long companyId) {
                this.reservationEquipmentStockDTO = reservationEquipmentStockDTO;
                this.stocks = stocks;
                this.companyId = companyId;
        }

        public ReservationEqRequest(){

        }
}
