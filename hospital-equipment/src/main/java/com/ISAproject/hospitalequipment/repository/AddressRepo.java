package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.Address;
import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo  extends JpaRepository<Address,Long> {

    List<Address> findAll();

    Address save(Address address);
}
