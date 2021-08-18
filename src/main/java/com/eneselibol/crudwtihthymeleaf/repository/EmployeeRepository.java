package com.eneselibol.crudwtihthymeleaf.repository;

import com.eneselibol.crudwtihthymeleaf.model.Employee;
import com.eneselibol.crudwtihthymeleaf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT u FROM Employee u WHERE u.user_id = :user_id")
    public Employee getEmployeeByUser_id(@Param("user_id") Long user_id);
}
