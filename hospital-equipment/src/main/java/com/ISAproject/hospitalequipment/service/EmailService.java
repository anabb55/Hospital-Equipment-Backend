package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.google.zxing.WriterException;
import jakarta.mail.MessagingException;
import org.springframework.mail.SimpleMailMessage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface EmailService {

    public void sendEmail(User user);

    public void SendEmailWithQRCode(String text, User user) throws IOException, WriterException;
    public void sendReservationEmail(User user);


}
