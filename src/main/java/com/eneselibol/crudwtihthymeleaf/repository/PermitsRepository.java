package com.eneselibol.crudwtihthymeleaf.repository;

import com.eneselibol.crudwtihthymeleaf.model.Permits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermitsRepository extends JpaRepository<Permits,Long> {

    @Query("select p from Permits p where p.employee.employeeId=?1")
    List<Permits> getPermitsByEmployee(long employeeId);

    @Query("select s from Permits s where s.status=0")
    List<Permits> getAllByStatusZero();



}
