package com.ISAproject.hospitalequipment;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EntityScan(basePackages = "com.ISAproject.hospitalequipment.domain")
@EnableAsync
public class HospitalEquipmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalEquipmentApplication.class, args);

	}


	//bean za konekciju na RabbitMQ
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		return connectionFactory;
	}

}
