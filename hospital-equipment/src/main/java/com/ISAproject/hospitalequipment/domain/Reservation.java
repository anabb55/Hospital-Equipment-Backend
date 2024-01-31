package com.ISAproject.hospitalequipment.domain;

import com.ISAproject.hospitalequipment.domain.enums.AppointmentStatus;
import com.ISAproject.hospitalequipment.domain.enums.QRCodeStatus;
import com.ISAproject.hospitalequipment.domain.enums.ReservationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Reservations")
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;



    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @OneToMany(mappedBy = "reservation", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ReservationEquipmentStock> reservationEquipmentStocks = new HashSet<ReservationEquipmentStock>();

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;


    @JoinColumn(name = "registered_user_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private RegisteredUser registeredUser;


    public Reservation(){}
    public Reservation(Long id, ReservationStatus reservationStatus, Appointment appointment, RegisteredUser registeredUser){
        this.id  = id;
        this.reservationStatus = reservationStatus;
        this.appointment = appointment;
         this.registeredUser = registeredUser;
    }


}
