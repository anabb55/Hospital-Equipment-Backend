package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.SystemAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAdminRepo extends JpaRepository<SystemAdmin, Long> {

}
