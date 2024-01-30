package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Reservation;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ReservationService {

    public Reservation save(Reservation reservation);


    public Reservation getLast();

    public List<Reservation> getAll();

    public Boolean isReservationTaken(int idAppointment);

    public Reservation create(Reservation reservation);

    public void getDataForQRCode() throws IOException, WriterException;

    public List<Map<String, Object>> getDataForUserQRCode(Long userId, String status) throws WriterException, IOException ;


    void deleteByAppointmentId(Long appointmentId);

    Reservation findByAppointmentId(Long appointmentId);

    public Reservation getById(Long id);

    public Reservation saveReservation(Reservation reservation);

    List<Reservation> findByRegisteredUserId(Long userId);

    public void checkExpiredReservations();



}
