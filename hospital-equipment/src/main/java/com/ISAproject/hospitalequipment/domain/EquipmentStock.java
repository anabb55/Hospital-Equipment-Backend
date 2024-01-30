package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="equipment_stock")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = EquipmentStock.class)
public class EquipmentStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Version
    private Long version = 0L;

    @JoinColumn(name = "equipment_id")
    @ManyToOne(fetch=FetchType.LAZY)
    Equipment equipment;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="company_id")
 
    Company company;


    @Column(name = "amount")
    Long amount;

    @Column(name = "price")
    Long price;

    @OneToMany(mappedBy = "equipmentStock", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ReservationEquipmentStock> reservationEquipmentStocks = new HashSet<ReservationEquipmentStock>();

    public EquipmentStock(Equipment equipment, Company company, Long amount,Long price) {
        this.equipment = equipment;
        this.company = company;
        this.amount = amount;
        this.price=price;
    }
    public EquipmentStock(Long id,Equipment equipment, Company company, Long amount) {
        this.id = id;
        this.equipment = equipment;
        this.company = company;
        this.amount = amount;
    }

    public EquipmentStock(){}






}
