package com.eneselibol.crudwtihthymeleaf.service;


import com.eneselibol.crudwtihthymeleaf.model.Employee;
import com.eneselibol.crudwtihthymeleaf.model.Permits;
import com.eneselibol.crudwtihthymeleaf.repository.PermitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PermitsServiceImpl implements PermitsService {
    @Autowired
    private PermitsRepository permitsRepository;

    @Query()
    @Override
    public List<Permits> getAllPermits() {
        return permitsRepository.findAll();
    }

    @Override
    public Permits getPermitsById(Long id) {
//        Optional<Permits> optional = permitsRepository.findById(id);
//        Permits permits = null;
//        if (optional.isPresent()) {
//            permits = optional.get();
//        } else {
//            throw new RuntimeException(" Permits not found for id :: " + id);
//        }
//        return permits;
        return  permitsRepository.findById(id)
                .orElseThrow(()->new RuntimeException(" Permits not found for id :: " + id));
    }

    @Override
    public List<Permits> getPermitsByEmployeeId(long id) {

        return permitsRepository.getPermitsByEmployee(id);

    }

    @Override
    public void deletePermitsById(long id) {
        this.permitsRepository.deleteById(id);
    }

    @Override
    public void savePermits(Permits permits) {
        this.permitsRepository.save(permits);
    }

    @Override
    public void permitApprove(Long id) {
        Permits permits=permitsRepository.getById(id);
        permits.setStatus(1);
        permitsRepository.save(permits);
    }


}
