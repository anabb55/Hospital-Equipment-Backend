package com.ISAproject.hospitalequipment;

import com.ISAproject.hospitalequipment.domain.Equipment;
import com.ISAproject.hospitalequipment.domain.ReservationEquipmentStock;
import com.ISAproject.hospitalequipment.service.ReservationEquipmentStockService;
import jakarta.persistence.OptimisticLockException;
import org.hibernate.StaleObjectStateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HospitalEquipmentApplicationTests {

	@Autowired
	private ReservationEquipmentStockService reservationEquipmentStockService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testConcurrentEquipmentReservation() throws InterruptedException {
		Long companyId = 1L;

		List<Equipment> equipments = new ArrayList<>();

		equipments.add(new Equipment(1L, "Scissors", "Strong medical scissors", "Medical", 5.0, 50L));
		equipments.add(new Equipment(2L, "Gloves", "Disposable medical gloves", "Medical", 4.0, 2000L));
		equipments.add(new Equipment(3L, "Coat", "Cotton lab coat", "Apparel", 5.0, 500L));
		equipments.add(new Equipment(4L, "Bandage", "Elastic bandage", "Medical", 5.0, 500L));

		ReservationEquipmentStock sharedReservationStock = new ReservationEquipmentStock();


		int numberOfThreads = 10;
		Thread[] threads = new Thread[numberOfThreads];
		for (int i = 0; i < numberOfThreads; i++) {
			threads[i] = new Thread(() -> {
				try {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("USPESNO ");
					reservationEquipmentStockService.save(equipments, sharedReservationStock, companyId);
				} catch (OptimisticLockException optimisticLockException) {
					System.out.println("Detektovan konflikt"+optimisticLockException.getMessage());
				}
			});
		}

		// Pokretanje svih niti
		for (Thread thread : threads) {
			thread.start();
		}

		// Čekanje da se sve niti završe
		for (Thread thread : threads) {
			thread.join();
		}
	}

}
