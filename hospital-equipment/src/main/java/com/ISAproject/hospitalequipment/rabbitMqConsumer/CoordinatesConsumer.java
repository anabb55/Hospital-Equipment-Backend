package com.ISAproject.hospitalequipment.rabbitMqConsumer;

import com.ISAproject.hospitalequipment.dto.LocationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoordinatesConsumer {


    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    private static final Logger log = LoggerFactory.getLogger(CoordinatesConsumer.class);


    //kreira se listener koji je konektovan na RabbitMQ queue i koji ce prosledjivati poruke metodi
    //myqueue je naziv queue sa kojeg citamo poruku
    @RabbitListener(queues="spring-boot2")

    @Scheduled(fixedRate = 5000)
    public void handler(LocationDTO location) {
        if (location != null ) {

            System.out.println("Latitude: " + location.getLatitude() + ", Longitude: " + location.getLongitude());

            this.messagingTemplate.convertAndSend("/topic/location-updates", location);

        } else {

            System.out.println("Empty.");
        }
    }

}