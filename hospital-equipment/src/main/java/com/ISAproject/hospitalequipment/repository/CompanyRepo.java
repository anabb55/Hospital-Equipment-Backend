package com.ISAproject.hospitalequipment.repository;

import com.ISAproject.hospitalequipment.domain.Company;
import com.ISAproject.hospitalequipment.domain.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {



    List<Company> findAll();
    Company save(Company company);



    @Query("SELECT cp FROM Company cp JOIN cp.administrators a WHERE a.id = :administratorId")
    List<Company> findCompaniesByAdministrators(@Param("administratorId")int id);


    /* nisam sigurna da li ce raditi
    List<Company> findCompaniesByEquipment(Equipment equipmentId);
*/
    List<Company> findByNameContainingIgnoreCaseOrAddressCityContainingIgnoreCase(String name, String city);
    List<Company> findByGrade(Integer rate);

    @Query("SELECT es.equipment FROM EquipmentStock es WHERE es.company.id = :companyId")
    List<Equipment> findEquipmentByCompanyId(@Param("companyId") Long companyId);

    @Query("SELECT es.equipment FROM EquipmentStock es WHERE es.company.id = :companyId AND es.equipment.name LIKE %:name%")
    List<Equipment> findEquipmentByCompanyIdAndName(@Param("companyId") Long companyId, @Param("name") String name);



}
