package com.eneselibol.crudwtihthymeleaf.service;

import com.eneselibol.crudwtihthymeleaf.model.Roles;
import com.eneselibol.crudwtihthymeleaf.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService{

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public void saveUserRole(Roles roles) {
        this.rolesRepository.save(roles);
    }
}
