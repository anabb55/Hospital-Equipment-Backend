package com.ISAproject.hospitalequipment;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.ISAproject.hospitalequipment.domain")

public class HospitalEquipmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalEquipmentApplication.class, args);

	}

}
