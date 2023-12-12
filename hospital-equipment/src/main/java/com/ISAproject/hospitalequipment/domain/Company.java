package com.ISAproject.hospitalequipment.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="Company")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Company.class)
public class Company {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @NotNull
    private Address address;

    @NotNull
    private String description;

    @NotNull
    private Double grade;


    @OneToMany(mappedBy = "company", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<Appointment>();



    /*
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="company_equipment",
            joinColumns = @JoinColumn(name="company_profile_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id", referencedColumnName = "id"))
    private Set<Equipment> equipment = new HashSet<Equipment>();
*/
    @OneToMany(mappedBy = "company")
    private Set<EquipmentStock> equipmentStock ;


    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<CompanyAdministrator> administrators = new HashSet<CompanyAdministrator>();

    public Company(Long id, String name, String description, Address address, Double grade) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.grade = grade;
        this.address = address;
    }

    public Company() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Set<EquipmentStock> getEquipmentStock() {
        return equipmentStock;
    }

    public void setEquipmentStock(Set<EquipmentStock> equipmentStock) {
        this.equipmentStock = equipmentStock;
    }

    public Set<CompanyAdministrator> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(Set<CompanyAdministrator> administrators) {
        this.administrators = administrators;
    }

    public void addEquipmentStock(EquipmentStock equipmentStock){
        this.equipmentStock.add(equipmentStock);
    }

}
