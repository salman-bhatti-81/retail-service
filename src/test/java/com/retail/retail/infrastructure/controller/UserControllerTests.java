package com.retail.retail.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.retail.domain.User;
import com.retail.retail.infrastructure.controller.dto.UserDTO;
import com.retail.retail.usecase.service.UserService;
import com.retail.retail.usecase.service.UserType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(controllers = UserController.class)
@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user;
    private UserDTO userDTO;

    //convert an object to json string
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void init () {
        user = new User("Ken", UserType.EMPLOYEE);
        userDTO = new UserDTO(UserType.EMPLOYEE.toString(),"Ken");
    }

    @Test
    public void UserController_CreateUser_ReturnAdded () throws Exception {


        // Mocking the service behavior
        given(userService.createNewUser(user)).willReturn(user);

        // Performing an HTTP POST request to create an employee
        ResultActions response = this.mockMvc.perform(post("/v1/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userDTO)));

        // Asserting the response expectations
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("message", CoreMatchers.is("user added")));
    }

}
