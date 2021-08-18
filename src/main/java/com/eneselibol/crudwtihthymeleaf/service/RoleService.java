package com.eneselibol.crudwtihthymeleaf.service;

import com.eneselibol.crudwtihthymeleaf.model.Roles;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    void saveUserRole(Roles roles);
}
