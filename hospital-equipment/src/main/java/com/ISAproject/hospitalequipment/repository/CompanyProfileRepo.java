package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.Model.CompanyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyProfileRepo extends JpaRepository<CompanyProfile,Long> {



}