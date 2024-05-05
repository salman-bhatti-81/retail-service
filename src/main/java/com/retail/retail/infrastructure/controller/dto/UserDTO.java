package com.retail.retail.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    String userType;
    String userName;

    public boolean isValid(){
        if("".equals(this.userType) || "".equals(this.userName)){
            return false;
        }
        return true;
    }
}
