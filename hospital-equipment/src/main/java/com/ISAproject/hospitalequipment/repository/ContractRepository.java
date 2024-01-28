package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.Contract;
import com.ISAproject.hospitalequipment.domain.enums.ContractStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {
    @Query("SELECT COUNT(c) > 0 FROM Contract c WHERE c.date = :date AND c.contractStatus = :status")
    boolean existsByDateAndStatus(@Param("date") LocalDate date, @Param("status") ContractStatus status);

    @Query("SELECT c FROM Contract c WHERE  c.contractStatus = :status")
    Contract getValidContract(@Param("status") ContractStatus status);

}
