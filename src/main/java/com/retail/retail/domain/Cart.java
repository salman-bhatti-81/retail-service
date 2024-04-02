package com.retail.retail.domain;

import com.retail.retail.service.strategy.RetailStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Item> items;

    public Cart(){
        items = new ArrayList<>();
    }

    public void AddItem(Item item){
        items.add(item);
    }

    public double totalAmount(){
        double sum = 0;
        for (Item item : this.items) {
            sum = sum + item.getPrice();
        }
         return sum;
    }

    public double calculateBill(RetailStrategy strategy){
        return strategy.amountPayable(this.totalAmount());
    }
}
