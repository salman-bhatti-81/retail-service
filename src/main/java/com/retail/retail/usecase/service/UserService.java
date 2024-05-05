package com.retail.retail.usecase.service;

import com.retail.retail.domain.User;
import com.retail.retail.domain.UserRepository;
import com.retail.retail.infrastructure.controller.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createNewUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public List<User> fetchAllUsers(){
        return userRepository.findAll();
    }
}
