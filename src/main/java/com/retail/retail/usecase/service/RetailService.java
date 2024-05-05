package com.retail.retail.usecase.service;

import com.retail.retail.domain.Cart;
import com.retail.retail.domain.Item;
import com.retail.retail.domain.User;
import com.retail.retail.usecase.service.strategy.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailService {

    public double calculateTotalBill(User user, List<Item> items){
        Cart cart = new Cart();

        items.forEach((item) -> cart.AddItem(item));
        RetailStrategy strategy;
        switch (user.getUserType()){
            case GENERAL:
                strategy = new GeneralStrategy();
                break;
            case AFFILIATE:
                strategy = new AffiliateStrategy();
                break;
            case CUSTOMER:
                strategy = new CustomerStrategy();
                break;
            case EMPLOYEE:
                strategy = new EmployeeStrategy();
                break;
            default:
                return 0.0;
        }

        return cart.calculateBill(strategy);
    }
}
