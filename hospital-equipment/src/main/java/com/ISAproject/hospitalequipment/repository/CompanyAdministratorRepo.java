package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface CompanyAdministratorRepo extends JpaRepository<CompanyAdministrator,Long> {
    CompanyAdministrator save(CompanyAdministrator admin);

    //List<CompanyAdministrator> findByCompany(CompanyProfile company);
    @Query("SELECT a FROM CompanyAdministrator a " +
            "WHERE NOT EXISTS (" +
            "  SELECT 1 FROM Appointment app " +
            "  WHERE app.administrator = a " +
            "    AND app.date = :date " +
            "    AND (app.startTime < :endTime AND (app.startTime + app.duration) > :startTime)" +
            ")")
    CompanyAdministrator findAvailableAdministrator(
            @Param("date") LocalDate date,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime);


}
