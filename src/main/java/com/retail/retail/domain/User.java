package com.retail.retail.domain;


import com.retail.retail.usecase.service.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    UserType userType;
    String userName;

    public User(String userName, UserType type){
        this.userName = userName;
        this.userType = type;
    }

    public UserType getUserType(){
        return this.userType;
    }


    public String getUserName(){
        return this.userName;
    }
}
