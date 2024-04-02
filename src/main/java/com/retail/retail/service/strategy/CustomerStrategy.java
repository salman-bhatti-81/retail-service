package com.retail.retail.service.strategy;

public class CustomerStrategy implements RetailStrategy {
    @Override
    public double amountPayable(double amount) {
        return 0.95*amount;
    }
}
