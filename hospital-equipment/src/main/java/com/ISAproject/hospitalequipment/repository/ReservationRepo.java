package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {


    @Query("SELECT r FROM Reservation r WHERE r.appointment.id = :appointmentId")
    Reservation findByAppointment(@Param("appointmentId") Long appointmentId);



    @Override
    List<Reservation> findAll();


    @Query("SELECT CASE WHEN r.reservationStatus = 'TAKEN' THEN true ELSE false END FROM Reservation r WHERE r.appointment.id = :idAppointment")
    Boolean isReservationTaken(@Param("idAppointment") int idAppointment);

    List<Reservation> findByRegisteredUserId(Long userId);

}
