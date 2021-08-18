package com.eneselibol.crudwtihthymeleaf.service;

import com.eneselibol.crudwtihthymeleaf.model.Permits;

import java.util.List;

public interface PermitsService {
    List<Permits> getAllPermits();
    Permits getPermitsById(Long id);
    List<Permits> getPermitsByEmployeeId(long id);
    void deletePermitsById(long id);
    void savePermits(Permits permits);
    void permitApprove(Long id);
}
