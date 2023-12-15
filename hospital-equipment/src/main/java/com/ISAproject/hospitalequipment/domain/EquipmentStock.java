package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Columns;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="equipment_stock")
public class EquipmentStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @JoinColumn(name = "equipment_id")
    @ManyToOne(fetch=FetchType.EAGER)

    Equipment equipment;

    @JoinColumn(name="company_id")

    @ManyToOne(fetch=FetchType.EAGER)

    Company company;
    @Column(name = "amount")
    int amount;

    @OneToMany(mappedBy = "equipmentStock", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ReservationEquipmentStock> reservationEquipmentStocks = new HashSet<ReservationEquipmentStock>();

    public EquipmentStock(Equipment equipment, Company company, int amount) {
        this.equipment = equipment;
        this.company = company;
        this.amount = amount;
    }
    public EquipmentStock(){}
    public Long getId() {
        return id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Company getCompany() {
        return company;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
