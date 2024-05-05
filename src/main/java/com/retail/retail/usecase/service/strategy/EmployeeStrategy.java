package com.retail.retail.usecase.service.strategy;

public class EmployeeStrategy implements RetailStrategy {
    @Override
    public double amountPayable(double amount) {
        return 0.7*amount;
    }
}
