package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.EquipmentStock;

public class EquipmentStockDTO {
        private Long id;
        private EquipmentDTO equipmentDTO;
        private CompanyDTO companyDTO;
        private Long amount;

        public EquipmentStockDTO(Long id, EquipmentDTO equipmentDTO, CompanyDTO companyDTO, Long amount) {
                this.id = id;
                this.equipmentDTO = equipmentDTO;
                this.companyDTO = companyDTO;
                this.amount = amount;
        }

         public EquipmentStockDTO(EquipmentStock equipmentStock)
         {
                 this.id=equipmentStock.getId();
                 this.amount=equipmentStock.getAmount();
                 this.equipmentDTO=new EquipmentDTO(equipmentStock.getEquipment());
                 this.companyDTO=new CompanyDTO(equipmentStock.getCompany());
         }

        public EquipmentStockDTO() {
        }
    }