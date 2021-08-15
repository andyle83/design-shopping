package com.java.shopping;

public class NonProfitCustomer extends  Customer {

    private final int NON_PROFIT_DISCOUNT = 15;

    public NonProfitCustomer(String name, long ccNumber) {
        super(name, ccNumber);
    }

    @Override
    public int calculateDiscount() {
        return NON_PROFIT_DISCOUNT;
    }
}
