package com.ISAproject.hospitalequipment.service.impl;

import com.ISAproject.hospitalequipment.domain.User;
import com.ISAproject.hospitalequipment.dto.UserDTO;
import com.ISAproject.hospitalequipment.repository.UserRepo;
import com.ISAproject.hospitalequipment.service.EmailService;
import com.ISAproject.hospitalequipment.service.QRCodeService;
import com.ISAproject.hospitalequipment.service.RegisteredUserService;
import com.ISAproject.hospitalequipment.service.UserService;
import com.google.zxing.WriterException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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

    @Autowired
    private QRCodeService qrCodeService;


    @Async
    public void sendEmail(User user)  {
        String subject = "Complete Registration";

        String titile="Comfirm your email";
        String text ="To confirm your account, please click here : " + "http://localhost:8081/api/authentication/verify?email=" + user.getEmail();

        try {
            sendMess(user, subject,text);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private void sendMess(User user, String subject, String text)  throws MessagingException, IOException{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("isaisaprojekat.com");

        helper.setTo(user.getEmail());
        helper.setSubject(subject);


       helper.setText(text);
        javaMailSender.send(message);
    }

    private void sendMessWithQR(User user, String subject, String text,byte[] qrCodeImage)  throws MessagingException, IOException{

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true);

        helper.setFrom("isaisaprojekat.com");

        helper.setTo(user.getEmail());
        helper.setSubject(subject);


        helper.addAttachment("qrcode.png", new ByteArrayResource(qrCodeImage));
        helper.setText(text);
        javaMailSender.send(message);
    }

    public void SendEmailWithQRCode(String text, User user) throws IOException, WriterException {
        String subject = "QR Code for Reservation";
        String emailText = "Scan QR code for more informations about your reservation";

        byte[] qrCodeBytes = qrCodeService.getQRCodeImage(text,300, 300);

        try {
            sendMessWithQR(user, subject,emailText,qrCodeBytes);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

    @Async
    public void sendReservationEmail(User user)  {
        String subject = "Reservation confirmation";

        String titile="Reservation Confirmation";
        String text ="To confirm taking your reservation, please click here : " + "http://localhost:8081/api/authentication/verifyReservation?email=" + user.getEmail();

        try {
            sendMess(user, subject,text);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
