package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Reservation;
import com.ISAproject.hospitalequipment.repository.ReservationRepo;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public interface ReservationService {

    public Reservation save(Reservation reservation);


    public Reservation getLast();

    public List<Reservation> getAll();


    public Reservation create(Reservation reservation);

    public void getDataForQRCode() throws IOException, WriterException;

}
