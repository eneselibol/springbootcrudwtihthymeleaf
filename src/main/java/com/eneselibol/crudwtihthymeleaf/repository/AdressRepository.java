package com.eneselibol.crudwtihthymeleaf.repository;

import com.eneselibol.crudwtihthymeleaf.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Adress,Long> {
    
}
