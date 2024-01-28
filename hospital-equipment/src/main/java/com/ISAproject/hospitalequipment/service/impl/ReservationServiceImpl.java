package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.*;
import com.ISAproject.hospitalequipment.repository.EquipmentStockRepo;
import com.ISAproject.hospitalequipment.repository.ReservationEquipmentStockRepo;
import com.ISAproject.hospitalequipment.repository.ReservationRepo;
import com.ISAproject.hospitalequipment.service.AppointmentService;
import com.ISAproject.hospitalequipment.service.EmailService;
import com.ISAproject.hospitalequipment.service.QRCodeService;
import com.ISAproject.hospitalequipment.service.ReservationService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private ReservationEquipmentStockRepo reservationEquipmentStockRepo;
    @Autowired
    private EquipmentStockRepo equipmentStockRepo;

    @Autowired
    AppointmentService appointmentService;


    @Autowired
   private EmailService emailService;

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


    public void getDataForQRCode() throws IOException, WriterException {
        List<Reservation> reservations = reservationRepo.findAll();
        List<ReservationEquipmentStock> reservationEquipmentStocks = reservationEquipmentStockRepo.findAll();


        List<EquipmentStock> equipmentStocks = equipmentStockRepo.findAll();
        Long amount = 0L;
        Equipment equipment = new Equipment();


        Reservation res = reservations.get(reservations.size() - 1);


        Appointment appointment = res.getAppointment();
        //Oprema koju preuzima
        ReservationEquipmentStock reservationEquipmentStock = reservationEquipmentStocks.stream()
                .filter(r -> Objects.equals(r.getReservation(), res))
                .findFirst()
                .orElse(null);

        if (reservationEquipmentStock != null) {
            amount = reservationEquipmentStock.getAmount();

            // Find EquipmentStock for the given ReservationEquipmentStock
            EquipmentStock equipmentStock = equipmentStocks.stream()
                    .filter(e -> Objects.equals(e, reservationEquipmentStock.getEquipmentStock()))
                    .findFirst()
                    .orElse(null);

            if (equipmentStock != null) {
                equipment = equipmentStock.getEquipment();
            }
        }

        //termini
        String startTime = appointment.getStartTime().toString();
        String endTime = appointment.getEndTime().toString();
        String date = appointment.getDate().toString();

        User user = res.getRegisteredUser();

        //korisnik koji preuzima
        String name = user.getFirstname();
        String surname = user.getLastname();

        //admin kompanije
        CompanyAdministrator admin = appointment.getAdministrator();
        String adminName = admin.getFirstname();
        String adminSurname = admin.getLastname();

        //kompanija
        Company company = admin.getCompany();
        String companyName = company.getName();


        String allText="Date" + date + "\n"+ "\t"+
                startTime + " - " + endTime + "\n" +"\t"+
                "Reservation ID: " + res.getId()+ "\n" + "\t"+
                "User: " + name + " " + surname + "\n" +"\t"+
                "Admin: " + adminName + " " + adminSurname + "\n" +"\t"+
                "Company: " + companyName+"\n"+"\t"+
                "Equipment: " + equipment.getName() +"\t"+ "description: "+ equipment.getDescription()+ "\n"+"\t"+
                "Amount: " + amount;

        emailService.SendEmailWithQRCode(allText,user);



    }



    public void deleteByAppointmentId(Long appointmentId) {
       Reservation reservation = reservationRepo.findByAppointment(appointmentId);

       reservationRepo.delete(reservation);
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

    public Reservation getById(Long id){
        return reservationRepo.findById(id).get();
    }

    public Reservation saveReservation(Reservation reservation)
    {

        return reservationRepo.save(reservation);
    }
}
