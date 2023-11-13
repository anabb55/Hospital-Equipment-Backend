package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleRepo extends JpaRepository<Role, Long> {
    List<Role> findByName(String name);
}
