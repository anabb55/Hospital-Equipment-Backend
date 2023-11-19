package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Long> {

    Address save(Address address);
}
