package com.ISAproject.hospitalequipment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry
                                               registry) {
        registry.addEndpoint("/mywebsockets").setAllowedOrigins("*");    //na ovaj endpoint se klijenti povezuju sa serverom

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        config.enableSimpleBroker("/topic"); //na ove rute klijent moze da se pretplati
        config.setApplicationDestinationPrefixes("/app");   //svaki zahtev klijenta u sebi mora imati app rec(tako smo naveli)
    }




}

