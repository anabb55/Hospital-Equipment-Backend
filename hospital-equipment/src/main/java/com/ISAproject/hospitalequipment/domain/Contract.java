package com.ISAproject.hospitalequipment.domain;

import com.ISAproject.hospitalequipment.domain.enums.ContractStatus;
import com.ISAproject.hospitalequipment.domain.enums.EquipmentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

    @Getter
    @Setter
    @Entity
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Contract.class)
    @Table
    public class Contract {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @NotNull
        public long id;



        @NotEmpty
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        public LocalDate date;


        private String equipmentType;

        Long amount;

        @Enumerated(EnumType.STRING)
        private ContractStatus contractStatus;

        Long companyId;

        private Double longitude;
        private Double latitude;

    }


