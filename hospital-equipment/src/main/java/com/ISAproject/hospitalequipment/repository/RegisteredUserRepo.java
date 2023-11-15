package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository

public interface RegisteredUserRepo extends JpaRepository<RegisteredUser, Long> {
}
