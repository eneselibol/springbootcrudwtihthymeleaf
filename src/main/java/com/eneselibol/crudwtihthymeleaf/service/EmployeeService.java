package com.eneselibol.crudwtihthymeleaf.service;

import com.eneselibol.crudwtihthymeleaf.model.Adress;
import com.eneselibol.crudwtihthymeleaf.model.Employee;


import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    void saveAdress(Adress adress);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
    Employee getEmployeeByUsername(String username);
    Long getIdUserID(Long userId);
}
