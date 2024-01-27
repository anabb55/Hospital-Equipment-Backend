package com.ISAproject.hospitalequipment.rabbitMqConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesConsumer {

    private static final Logger log = LoggerFactory.getLogger(CoordinatesConsumer.class);

    //kreira se listener koji je konektovan na RabbitMQ queue i koji ce prosledjivati poruke metodi
    //myqueue je naziv queue sa kojeg citamo poruku
    @RabbitListener(queues="spring-boot1")
    public void handler(String message){
        log.info("CoordinatesConsumer> " + message);

    }
}
