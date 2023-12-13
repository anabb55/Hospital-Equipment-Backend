package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyAdministratorRepo extends JpaRepository<CompanyAdministrator,Long> {
    CompanyAdministrator save(CompanyAdministrator admin);


    List<CompanyAdministrator> findAll();
    //List<CompanyAdministrator> findByCompany(CompanyProfile company);
}
