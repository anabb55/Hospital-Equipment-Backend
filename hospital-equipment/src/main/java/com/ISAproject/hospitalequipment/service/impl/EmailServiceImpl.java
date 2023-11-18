package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.repository.UserRepo;
import com.ISAproject.hospitalequipment.service.EmailService;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import com.ISAproject.hospitalequipment.service.UserService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserService userService;


    @Async
    public void sendEmail(User user) throws UnsupportedEncodingException {
        String subject = "Complete Registration";
        String text = "Click on the link for activation";
        String titile="Comfirm your email";

        try {
            sendMess(user, subject);
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void sendMess(User user, String subject)  throws MessagingException, IOException{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("isaisaprojekat.com");

        helper.setTo(user.getEmail());
        helper.setSubject(subject);


       helper.setText("Ana pozuri, nemoj kasniti!");
        javaMailSender.send(message);
    }
}
