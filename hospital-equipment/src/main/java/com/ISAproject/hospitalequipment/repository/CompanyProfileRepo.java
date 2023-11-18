package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.CompanyProfile;
import com.ISAproject.hospitalequipment.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompanyProfileRepo extends JpaRepository<CompanyProfile,Long> {



   // @Query(value = "SELECT * FROM company_profiles", nativeQuery = true)
    List<CompanyProfile> findAll();
    CompanyProfile save(CompanyProfile company);

    List<CompanyProfile> findCompanyProfilesByEquipment(Equipment equipmentId);
}
