package com.eneselibol.crudwtihthymeleaf.controller;

import com.eneselibol.crudwtihthymeleaf.model.Employee;
import com.eneselibol.crudwtihthymeleaf.model.Permits;
import com.eneselibol.crudwtihthymeleaf.repository.PermitsRepository;
import com.eneselibol.crudwtihthymeleaf.service.EmployeeService;
import com.eneselibol.crudwtihthymeleaf.service.PermitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permits")
public class PermitsController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PermitsService permitsService;
    @Autowired
    private PermitsRepository permitsRepository;








}
