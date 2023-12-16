package com.ISAproject.hospitalequipment.dto;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.domain.enums.ReservationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDTO {

    private Long id;

    @NotNull
    private Long penaltyPoints;

    private ReservationStatus reservationStatus;

    private AppointmentDTO appointmentDTO;

    private RegisterUserDTO registeredUserDTO;
    public ReservationDTO(Reservation reservation)
    {
        this.id=reservation.getId();
        this.reservationStatus=reservation.getReservationStatus();
        this.penaltyPoints=reservation.getPenaltyPoints();
        this.appointmentDTO=new AppointmentDTO(reservation.getAppointment());
        this.registeredUserDTO=new RegisterUserDTO(reservation.getRegisteredUser());

    }


    public ReservationDTO() {
    }

    public ReservationDTO(Long id, @NotNull Long penaltyPoints, ReservationStatus reservationStatus) {
        this.id = id;
        this.penaltyPoints = penaltyPoints;
        this.reservationStatus = reservationStatus;
    }



}
