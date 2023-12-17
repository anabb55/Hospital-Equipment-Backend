package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.repository.ReservationRepo;
import com.ISAproject.hospitalequipment.service.AppointmentService;
import com.ISAproject.hospitalequipment.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    AppointmentService appointmentService;

    public List<Reservation> getAll()
    {
        return reservationRepo.findAll();
    }

    public Reservation getLast() {
        List<Reservation> reservations = reservationRepo.findAll();

        if (!reservations.isEmpty()) {
            return reservations.get(reservations.size() - 1);
        } else {
            return null;
        }
    }


    public Reservation save(Reservation reservation)
    {
        List<Appointment> appointmentList=appointmentService.findAll();
        Appointment lastAppointment = appointmentList.get(appointmentList.size() - 1);
        reservation.setAppointment(lastAppointment);

        return reservationRepo.save(reservation);
    }

    public Reservation create(Reservation reservation){
        return  reservationRepo.save(reservation);
    }

}
