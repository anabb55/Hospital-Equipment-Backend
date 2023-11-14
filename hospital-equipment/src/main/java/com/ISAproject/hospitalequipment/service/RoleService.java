package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Optional<Role> findById(Long id);
    List<Role> findByName(String name);
}
