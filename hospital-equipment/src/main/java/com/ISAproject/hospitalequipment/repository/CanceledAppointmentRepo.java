package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.CanceledAppointment;
import com.ISAproject.hospitalequipment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanceledAppointmentRepo extends JpaRepository<CanceledAppointment,Long> {


}
