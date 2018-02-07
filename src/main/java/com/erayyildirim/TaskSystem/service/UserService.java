package com.erayyildirim.TaskSystem.service;

import com.erayyildirim.TaskSystem.model.Role;
import com.erayyildirim.TaskSystem.model.User;
import com.erayyildirim.TaskSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService{



    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        userRepository.save(user);
    }

    public void createAdmin(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        userRepository.save(user);
    }

    public User findOneUser(String email){
        return  userRepository.findByEmailAddress(email);
    }

}
