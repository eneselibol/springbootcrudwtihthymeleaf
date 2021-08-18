package com.eneselibol.crudwtihthymeleaf.service;

import com.eneselibol.crudwtihthymeleaf.model.Adress;
import com.eneselibol.crudwtihthymeleaf.model.Employee;
import com.eneselibol.crudwtihthymeleaf.model.Permits;
import com.eneselibol.crudwtihthymeleaf.model.User;
import com.eneselibol.crudwtihthymeleaf.repository.AdressRepository;
import com.eneselibol.crudwtihthymeleaf.repository.EmployeeRepository;
import com.eneselibol.crudwtihthymeleaf.repository.PermitsRepository;
import com.eneselibol.crudwtihthymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AdressRepository adressRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }



    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public void saveAdress(Adress adress) {
        this.adressRepository.save(adress);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        User user=userRepository.getUserByUsername(username);
        Employee employee=employeeRepository.getEmployeeByUser_id(user.getUser_id());
        return employee;
    }

    @Override
    public Long getIdUserID(Long userId) {
        return null;
    }
}
