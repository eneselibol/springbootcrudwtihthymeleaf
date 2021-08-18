package com.eneselibol.crudwtihthymeleaf.service;

import com.eneselibol.crudwtihthymeleaf.model.User;
import com.eneselibol.crudwtihthymeleaf.repository.UserRepository;
import com.eneselibol.crudwtihthymeleaf.utilies.GenericUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public void save(User user) {
        user.setPassword(GenericUtil.passwordGenerator(user.getPassword()));
        userRepository.save(user);
    }


}
