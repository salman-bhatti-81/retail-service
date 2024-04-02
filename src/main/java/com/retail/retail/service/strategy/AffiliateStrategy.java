package com.retail.retail.service.strategy;

public class AffiliateStrategy implements RetailStrategy {
    @Override
    public double amountPayable(double amount) {
        return 0.9 * amount;
    }
}
