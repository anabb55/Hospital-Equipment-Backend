package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import jakarta.mail.MessagingException;
import org.springframework.mail.SimpleMailMessage;

import java.io.UnsupportedEncodingException;

public interface EmailService {

    public void sendEmail(User user) throws UnsupportedEncodingException;


}
