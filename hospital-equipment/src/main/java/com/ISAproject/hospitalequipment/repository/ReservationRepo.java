package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.appointment.id = :appointmentId")
    Reservation findByAppointment(@Param("appointmentId") Long appointmentId);


}
