package com.eneselibol.crudwtihthymeleaf.controller;

import com.eneselibol.crudwtihthymeleaf.model.Employee;
import com.eneselibol.crudwtihthymeleaf.model.Permits;
import com.eneselibol.crudwtihthymeleaf.model.Roles;
import com.eneselibol.crudwtihthymeleaf.repository.PermitsRepository;
import com.eneselibol.crudwtihthymeleaf.repository.RolesRepository;
import com.eneselibol.crudwtihthymeleaf.security.WebSecurityConfig;
import com.eneselibol.crudwtihthymeleaf.service.EmployeeService;
import com.eneselibol.crudwtihthymeleaf.service.PermitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PermitsService permitsService;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private PermitsRepository permitsRepository;


    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private WebSecurityConfig webSecurityConfig;


    @GetMapping("/")
    public String viewHomePage(Model model) {
//        User currentUser= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            Employee employee = employeeService.getEmployeeByUsername(username);
            model.addAttribute("listEmployees", employeeService.getEmployeeById(employee.getEmployeeId()));
        } else {
            String username = principal.toString();
        }
//        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }
    @GetMapping("/allEmployee")
    public String viewAllPermits(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "all_employees";
    }

    @GetMapping("/viewPermits/{id}")
    public String viewPermitsList(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("listPermits", permitsService.getPermitsByEmployeeId(id));
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee_permits";
    }


    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        List<Roles> roles = (List<Roles>) rolesRepository.findAll();
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("roleLists", roles);
        return "new_employee";
    }

    @GetMapping("/showNewPermitsForm/{id}")
    public String showNewPermitsForm(@PathVariable(value = "id") long id, Model model) {
        Permits permits = new Permits();
        model.addAttribute("permits", permits);
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "new_permits";
    }


    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        String encodedPassword = encoder.encode(employee.getUser_id().getPassword());
        employee.getUser_id().setPassword(encodedPassword);
        employee.getUser_id().setEnabled(true);
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employee.setEmployeeId(employee.getEmployeeId());
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @GetMapping("/403")
    public String error403() {
        return "error403";
    }

    @GetMapping("/deletePermits/{id}")
    public String deletePermits(@PathVariable(value = "id") long id) {
        this.permitsService.deletePermitsById(id);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdatePermits/{id}")
    public String showFormForUpdatePermits(@PathVariable(value = "id") long id, Model model) {
        Permits permits = permitsService.getPermitsById(id);
        model.addAttribute("permits", permits);
        return "update_permits";
    }

    @PostMapping("/savePermits/{id}")
    public String savePermits(@PathVariable(value = "id") long id, @ModelAttribute("permits") Permits permits) {
        Employee employee = employeeService.getEmployeeById(id);
        permits.setEmployee(employee);
        permits.setStatus(0);
        permitsService.savePermits(permits);
        return "redirect:/";
    }
    @GetMapping("/showPendingPermits")
    public String showPendingPermits(Model model) {
        List<Permits> pendingPermits = (List<Permits>) permitsRepository.getAllByStatusZero();
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("pendingPermits", pendingPermits);
        return "pending_permits";
    }
    @GetMapping("/approvePermit/{id}")
    public String approvePermit(@PathVariable(value = "id") long id,Model model) {
        permitsService.permitApprove(id);
        List<Permits> pendingPermits = (List<Permits>) permitsRepository.getAllByStatusZero();
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("pendingPermits", pendingPermits);
        return "pending_permits";

    }


}
