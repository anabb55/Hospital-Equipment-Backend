package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.Appointment;
import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.CompanyAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    //Ana ovo je metoda za tvoj deo!!
    @Query("SELECT a FROM Appointment a " +
            "WHERE a.administrator.company.id = :companyId " +
            "AND a.date = :date " +
            "AND (a.appointmentStatus = 'PREDEFINED')")
    List<Appointment> findFreeAppointmentsByCompanyAndDate(
            @Param("companyId") Long companyId,
            @Param("date") LocalDate date
    );

    @Query("SELECT a FROM Appointment a " +
            "WHERE a.administrator.company.id = :companyId " +
            "AND a.date = :date " +
            "AND (a.appointmentStatus = 'TAKEN' or a.appointmentStatus='PREDEFINED')")
    List<Appointment> findTakenAppointmentsByCompanyAndDate(
            @Param("companyId") Long companyId,
            @Param("date") LocalDate date
    );

//    @Query("SELECT app FROM Appointment app " +
//            "WHERE app.administrator = :administrator " +
//            "AND app.date = :date")
//    List<Appointment> findByAdministratorAndDate(
//            @Param("administrator") CompanyAdministrator administrator,
//            @Param("date") LocalDate date);


}
