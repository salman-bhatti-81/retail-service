package com.retail.retail.infrastructure.controller;

import com.retail.retail.domain.User;
import com.retail.retail.infrastructure.controller.dto.CreateUserResponse;
import com.retail.retail.infrastructure.controller.dto.UserDTO;
import com.retail.retail.usecase.service.UserType;
import com.retail.retail.usecase.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/v1/users")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody UserDTO userDTO) {
        if (!userDTO.isValid()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User user = new User(userDTO.getUserName(), UserType.valueOf(userDTO.getUserType()));
        userService.createNewUser(user);
        return ResponseEntity.ok(new CreateUserResponse("user added"));
    }


    @GetMapping(value = "/v1/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.fetchAllUsers();
        List<UserDTO> usersDTO = new ArrayList<>();
        for(User user:users){
            UserDTO userDTO = new UserDTO(user.getUserName(),user.getUserType().toString());
            usersDTO.add(userDTO);
        }
        return ResponseEntity.ok(usersDTO);
    }
}
