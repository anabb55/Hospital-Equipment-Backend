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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="reservation_id")
    private Reservation reservation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="equipment_stock_id")
    private EquipmentStock equipmentStock;

    @Column(name = "amount")
    Long amount;

    @Column(name = "total_price")
    Long totalPrice;


    public ReservationEquipmentStock(Long id, Reservation reservation, EquipmentStock equipmentStock, Long amount, Long totalPrice) {
        this.id = id;
        this.reservation = reservation;
        this.equipmentStock = equipmentStock;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public ReservationEquipmentStock() {
    }
}
