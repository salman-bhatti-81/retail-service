package com.retail.retail.usecase.service.strategy;

public class GeneralStrategy implements RetailStrategy {
    @Override
    public double amountPayable(double amount) {
        int numOfBills = (int) (amount / 100);
        return amount - (numOfBills * 5);
    }
}
