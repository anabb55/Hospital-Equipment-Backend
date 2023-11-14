package com.ISAproject.hospitalequipment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ISAproject.hospitalequipment.domain.People;

@Repository
public interface UserRepository extends JpaRepository<People, Long> {
    // dodatne metode repozitorijuma, ako ih ima
}
