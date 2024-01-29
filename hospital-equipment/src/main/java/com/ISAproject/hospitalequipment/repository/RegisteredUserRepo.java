package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;
import com.ISAproject.hospitalequipment.domain.Role;
import com.ISAproject.hospitalequipment.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RegisteredUserRepo extends JpaRepository<RegisteredUser, Long> {

    RegisteredUser findByEmail(String email);

    Optional<RegisteredUser> findById(Long id);

}
