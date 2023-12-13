package com.ISAproject.hospitalequipment.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ReservationEquipmentStock")
@Getter
@Setter
public class ReservationEquipmentStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="reservation_id")
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="equipment_stock_id")
    private EquipmentStock equipmentStock;

    @Column(name = "amount")
    int amount;






}
