package com.eneselibol.crudwtihthymeleaf.utilies;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


public class GenericUtil {

    @Autowired
    private static PasswordEncoder bcyrptEncoder;

    public static String passwordGenerator(String password){
        return bcyrptEncoder.encode(password);
    }

}
