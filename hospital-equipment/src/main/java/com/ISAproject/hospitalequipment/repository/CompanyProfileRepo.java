package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompanyProfileRepo extends JpaRepository<CompanyProfile,Long> {



    List<CompanyProfile> findAll();
    CompanyProfile save(CompanyProfile company);

    @Query("SELECT cp FROM CompanyProfile cp JOIN cp.administrators a WHERE a.id = :administratorId")
    List<CompanyProfile> findCompanyProfilesByAdministrators(@Param("administratorId")int id);


}
