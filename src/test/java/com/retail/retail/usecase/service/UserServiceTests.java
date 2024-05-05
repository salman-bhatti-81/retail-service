package com.retail.retail.usecase.service;

import com.retail.retail.domain.User;
import com.retail.retail.domain.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    // it is used to create object in order to inject mock dependency i.e repo
    @InjectMocks
    private UserService userService;

    @Test
    void createUserSuccessfully(){
        final User user = new User("test@test.com", UserType.EMPLOYEE);
        final User dbuser = new User((long) 1, UserType.EMPLOYEE,"test@test.com");
        given(userRepository.save(user)).willReturn(dbuser);

        User savedUser = userService.createNewUser(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isEqualTo(dbuser.getId());
        Assertions.assertThat(savedUser.getUserName()).isEqualTo(dbuser.getUserName());
        Assertions.assertThat(savedUser.getUserType()).isEqualTo(dbuser.getUserType());
    }
}
